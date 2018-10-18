package com.session.sessiontest1.factory;


import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class HumanFactory {

    private static HashMap<String,Human> humans = new HashMap<String,Human>();

    public static Human createHuman(Class c) {
        Human human = null;
        try {
            if (humans.containsKey(c.getSimpleName())){
                human = humans.get(c.getSimpleName());
            }else {
                human = (Human)Class.forName(c.getName()).newInstance();
                //放到MAP中
                humans.put(c.getSimpleName(), human);
            }
           // human = (Human) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            System.out.println("必须指定人类的颜色");
        } catch (IllegalAccessException e) {
            System.out.println("人类定义错误！");
        } catch (ClassNotFoundException e) {
            System.out.println("混蛋，你指定的人类找不到！");
        }
        return human;
    }

    public static Human createHuman() {
        Human human=null; //定义一个类型的人类
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class);
        Random random = new Random();
        int rand = random.nextInt(concreteHumanList.size());
        human = createHuman(concreteHumanList.get(rand));
        return human;
    }
}
