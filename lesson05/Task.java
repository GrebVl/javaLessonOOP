package lesson05;
import java.io.IOException;

/**
 * Любая из трёх
 * 
 * Создать калькулятор для работы с рациональными
 * и комплексными числами, организовать меню,
 * добавив в неё систему логирования.
 * 
 * Создать телефонный справочник с возможностью импорта
 * и экспорта данных в нескольких форматах.
 * под форматами понимаем структуру файлов, например:
 * - в файле на одной строке хранится одна часть записи,
 * пустая строка - разделитель
 * 
 * Создать информационную систему позволяющую
 *  работать с сотрудниками некой компании \ 
 * студентами вуза \ учениками школы
 */

public class Task {

    public static void main(String[] args) throws IOException {
        new Menu().mainMenu();   
    }

    
}
