package Lesson06;
import java.io.IOException;
/**
 * Продумать пример работы некой системы:
 * - игры ( можно вспомнить игру с конфетами или шашки, шахматы и т д)
 * - текстового процессора
 * - информационной системы
 * или отдельно
 * - настроект приложения и т д
 * 
 * с возможностью сохранения всего состояния системы
 * и возврата её к выбранному состоянию.
 * 
 * будет ли работать ваш подход,
 * если в системе появится нечто похожее на
 * 
 * class Model {
 *     Model model;
 * }
 */
public class Program {
    public static void main(String[] args) throws IOException{
        Menu m = new Menu();
        m.mainMenu();
    }
    
}