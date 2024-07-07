/*
Реализовать иерархию классов, описывающую трехмерные фигуры

Класс Box является контейнером, он можем содержать в себе другие фигуры.
Метод add() принимает на вход Shape. Нужно добавлять новые фигуры до тех пор,
пока для них хватаем места в Box (будем считать только объём, игнорируя форму.
Допустим, мы переливаем жидкость). Если места для добавления новой фигуры
не хватает,то метод должен вернуть false.

Схема классов в ClassScheme.png
 */

package Task_04_0;

public class Main {
    public static void main(String args[]) {
        Box box = new Box(3, 3, 3);    // Box volume 27
        System.out.printf("Box volume = %f\n", box.getVolume());

        // Only one shape
        //Cylinder cylinder = new Cylinder(2, 2); // True
        //Cylinder cylinder = new Cylinder(3, 2); // False

        // Some shapes
        Cylinder cylinder = new Cylinder(1, 2);
        Pyramid pyramid = new Pyramid(5, 5);
        Ball ball = new Ball(1.8);


        System.out.printf("Cylinder volume = %f\n", cylinder.getVolume());
        System.out.printf("Pyramid volume = %f\n", pyramid.getVolume());
        System.out.printf("Ball volume = %f\n", ball.getVolume());
        System.out.println(box.add(cylinder));
        System.out.println(box.add(pyramid));
        System.out.println(box.add(ball));
    }
}
