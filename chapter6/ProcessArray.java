package chapter6;

public class ProcessArray {
    public void process(int[] target, Command cmd){
        for(var t : target){
            cmd.process(t);
        }
    }
}
/**
 * 通过一个Command接口就实现了让ProcessArray类和具体“处理行为”的分离程序使用Command接口代表了对数组元素的处理行为。Command接口也没有提供真正的处理，
 * 只有等到需要调用ProcessArray对象的process方法时，才真正的
 * 传入了一个Command对象，才确定对数组的处理行为
 */
