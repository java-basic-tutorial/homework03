package com.softserveinc.task02;

import com.softserveinc.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.*;

import static com.softserveinc.TestUtil.*;

public class CityTest {

    public static final  String CLASS_NAME = "com.softserveinc.task02.City";

    public static final Class<?> CITY_CLAZZ;

    static {
        Class<?> cls;
        try {
            cls = Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException ex) {
            cls = null;
        }
        CITY_CLAZZ = cls;
    }


    @Test
    @Order(1)
    @DisplayName("Проверка наличия класса City")
    void classExists() {
        isPublicNoStaticNoFinalNoAbstractClass(CITY_CLAZZ, CLASS_NAME);
    }

    @Order(2)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка закрытых полей")
    @ValueSource(strings = {"name", "region", "country", "inhabitants"})
    void privateFieldExists(String fieldName) throws NoSuchFieldException {
        hasPrivateNoStaticField(CITY_CLAZZ, fieldName);
    }

    @Order(2)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка геттеров")
    @CsvSource({"java.lang.String,getName", "java.lang.String,getRegion", "java.lang.String,getCountry", "int,getInhabitants"})
    void publicGetterExists(Class<?> returnType, String getterName) throws NoSuchMethodException {
        hasPublicNoStaticMethod(CITY_CLAZZ, returnType, getterName);
    }

    @Order(3)
    @ParameterizedTest(name = "{1}")
    @DisplayName("Проверка сеттеров")
    @CsvSource({"java.lang.String,setName", "java.lang.String,setRegion", "java.lang.String,setCountry", "int,setInhabitants"})
    void publicSetterExists(Class<?> clazz, String setterName) throws NoSuchMethodException {
        hasPublicNoStaticMethod(CITY_CLAZZ, setterName, clazz);
    }

    @Order(4)
    @ParameterizedTest(name = "{1}")
    @DisplayName("Проверка сеттеров/геттеров")
    @CsvSource({"java.lang.String,name", "java.lang.String,region", "java.lang.String,country", "int,inhabitants"})
    void setterGetterWork(Class<?> clazz, String fieldName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName(CLASS_NAME);
        Object obj = cls.getDeclaredConstructor().newInstance();

        String setterName = String.format("set%c%s", Character.toUpperCase(fieldName.charAt(0)), fieldName.substring(1));
        String getterName = String.format("get%c%s", Character.toUpperCase(fieldName.charAt(0)), fieldName.substring(1));

        Method setter = cls.getDeclaredMethod(setterName, clazz);
        Method getter = cls.getDeclaredMethod(getterName);
        Object expected = getExpected(clazz);
        setter.invoke(obj, expected);
        Object actual = getter.invoke(obj);
        Assertions.assertEquals(expected, actual);
    }

    @Order(5)
    @Test
    @DisplayName("Проверка Конструкторов")
    void constructors() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName(CLASS_NAME);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Assertions.assertEquals(2, declaredConstructors.length);

        Class<String> stringClass = String.class;
        Class<Integer> integerClass = int.class;
        Constructor<?> ctor = cls.getDeclaredConstructor(stringClass, stringClass, stringClass, integerClass);

        String name = randomString();
        String region = randomString();
        String country = randomString();
        int inhabitants = TestUtil.rnd.nextInt(8_000_000);

        Object human = ctor.newInstance(name, region, country, inhabitants);

        Method getName = cls.getDeclaredMethod("getName");
        Assertions.assertEquals(name, getName.invoke(human));

        Method getRegion = cls.getDeclaredMethod("getRegion");
        Assertions.assertEquals(region, getRegion.invoke(human));

        Method getCountry = cls.getDeclaredMethod("getCountry");
        Assertions.assertEquals(country, getCountry.invoke(human));

        Method getInhabitants = cls.getDeclaredMethod("getInhabitants");
        Object invoke = getInhabitants.invoke(human);
        Assertions.assertEquals(inhabitants, invoke);
    }
}
