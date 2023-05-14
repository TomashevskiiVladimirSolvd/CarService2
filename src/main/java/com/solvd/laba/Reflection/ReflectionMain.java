package com.solvd.laba.Reflection;

import com.solvd.laba.CarServices.CarServiceTrailers;
import com.solvd.laba.Employees.Boss;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class classReflection1 = Class.forName("com.solvd.laba.Employees.Boss");
        System.out.println(Stream.of(classReflection1.getDeclaredMethods())
                .map(Method::getName)
                .collect(Collectors.toList()));

        Boss boss = new Boss("Ivan Ivanov", "Boss of the boss", "50 Ford street", 4);
        boss.printInfo();

        Method setAddressMethod = classReflection1.getMethod("setAddress", String.class);
        setAddressMethod.invoke(boss, "55 Ferrari street");
        boss.printInfo();


        Constructor<CarServiceTrailers> constructor = CarServiceTrailers.class.getConstructor(String.class, String.class, long.class, boolean.class);

        CarServiceTrailers carServiceTrailers = constructor.newInstance("BestTrailerEver", "23 Evy street", 98778965, true);
        System.out.println("Name: " + carServiceTrailers.getName());
        System.out.println("Address: " + carServiceTrailers.getAddress());
        System.out.println("honeNumber: " + carServiceTrailers.getPhoneNumber());
        System.out.println("isFridgeInStock: " + carServiceTrailers.isFridgeInStock());


    }
}
