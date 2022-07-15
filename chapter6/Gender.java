package chapter6;


public enum Gender implements GenderDesc {
    // MALE,FEMALE;
    // private String name;
    // public void setName(String name){
    //     switch (this){
    //         case MALE:
    //         if(name.equals("男")){
    //             this.name = name;
    //         }
    //         else{
    //             System.out.println("参数错误");
    //             return;
    //         }
    //         break;
    //         case FEMALE:
    //         if(name.equals("女")){
    //             this.name = name;
    //         }
    //         else{
    //             System.out.println("参数错误");
    //         }
    //         break;
    //     }
    // }
    // public String getName(){
    //     return this.name;
    // }
    /**
     * 仍然不好，因为不希望改动，想要枚举类的所有成员变量都用private final修饰
     * 
     */
    
    //  //这个版本好

    //  MALE("男"),FEMALE("女");
    //  private final String name;
    //  //枚举类的构造器只能使用private修饰
    //  private Gender(String name)
    //  {
    //     this.name = name;
    //  }
    //  public String getName(){
    //     return this.name;
    //  }
     /**
      * 含有抽象方法的类（包括直接定义了一个抽象方法；或继承了一个抽象父类，但没有完全实现父类包含的抽象方法；
      * 或实现了一个接口，但没有完全实现接口包含的抽象方法三种情况）只能被定义成抽象类
      */
      MALE("男")
      //花括号是一个类体部分，实际上是在做一个匿名内部类
      {
        //在这里实现了接口的抽象方法
        public void info(){
            System.out.println("这个枚举值代表男性");
        }
      },
      FEMALE("女"){
        public void info(){
            System.out.println("这个枚举值代表女性");
        }
      };
      private final String name;
      private Gender(String name){
        this.name = name;
      }
      public String getName() {
          return name;
      }


}
