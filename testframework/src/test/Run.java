package test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;

import logger.Logger;
import logger.LoggerFactory;
import logger.WritingException;

public class Run {
    private static Logger logger;
    private static int nbTests;
    private static int nbFailedTests;

    public static void testClass(String className) {
        try { logger.info("PROGRAM", "testing class " + className); } catch (WritingException e){ System.out.println("Couldn't use logger.info");}
        try {
            Class<?> clazz = Class.forName(className);
            try {
                Object instance = clazz.newInstance();

                for (Method method : clazz.getDeclaredMethods()) {
                    int modifiers = method.getModifiers();
                    if (Modifier.isPublic(modifiers)) {
                        testMethod(clazz, instance, method);
                    }
                }
            } catch (InstantiationException | IllegalAccessException e) {
              try {logger.error("OUTPUT", "Couldn't instantiate " + clazz.getName());} catch (WritingException ee){ System.out.println(ee.getMessage());}
            }
        } catch (ClassNotFoundException e) {
            try {logger.error("OUTPUT", "class " + className + " not found");} catch (WritingException ee){ System.out.println(ee.getMessage());}
        }
    }

    public static void testMethod(Class<?> clazz, Object instance, Method method) {
      try {logger.info("PROGRAM", "running " + clazz.getName() + "." + method.getName());} catch (WritingException e){ System.out.println(e.getMessage());}
        nbTests++;
        boolean success = true;
        long testDurationMillis = 0;
        try {
            long startTimeMillis = System.currentTimeMillis();

            try {
                method.invoke(instance);
            } catch (IllegalAccessException e) {

                try {logger.error("OUTPUT", "could not invoke " + clazz.getName() + "." + method.getName());} catch (WritingException ee){System.out.println(ee.getMessage());}
                success = false;
            }
            testDurationMillis = System.currentTimeMillis() - startTimeMillis;
        } catch (InvocationTargetException e) {
            success = false;
        }

        String reportMsg;
        if (success) {
            reportMsg = String.format("%s.%s: OK (%d ms)", clazz.getName(), method.getName(), testDurationMillis);
        } else {
            reportMsg = String.format("%s.%s: KO (%d ms)", clazz.getName(), method.getName(), testDurationMillis);
            nbFailedTests++;
        }
        try {logger.info("OUTPUT", reportMsg);} catch (WritingException ee){System.out.println(ee.getMessage());}
    }

    public static void main(String[] args) {
        try {logger = LoggerFactory.getFileLogger();} catch (WritingException ee){System.out.println(ee.getMessage());}
        try {logger.info("PROGRAM", "Starting tests");} catch (WritingException ee){System.out.println(ee.getMessage());}
        long startTimeMillis = System.currentTimeMillis();
        for (String className: args) {
            testClass(className);
        }
        long totalTimeMillis = System.currentTimeMillis() - startTimeMillis;

        int nbPassedTests = nbTests - nbFailedTests;
        float passedRate = (float)nbPassedTests / nbTests * 100;
        float failedRate = (float)nbFailedTests / nbTests * 100;
        try {logger.info("OUTPUT", String.format("total  : %d", nbTests));} catch (WritingException ee){System.out.println(ee.getMessage());}
        try {logger.info("OUTPUT", String.format("passed : %d (%3.0f%%)", nbPassedTests, passedRate));} catch (WritingException ee){System.out.println(ee.getMessage());}
        try {logger.info("OUTPUT", String.format("failed : %d (%3.0f%%)", nbFailedTests, failedRate));} catch (WritingException ee){System.out.println(ee.getMessage());}
        try {logger.info("OUTPUT", String.format("time   : %d ms", totalTimeMillis));} catch (WritingException ee){System.out.println(ee.getMessage());}
    }
}
