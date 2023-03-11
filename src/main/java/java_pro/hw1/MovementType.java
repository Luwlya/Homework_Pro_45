package java_pro.hw1;
/*
Представьте, что Вы живете в Берлине и собираетесь поехать в Мюнхен.
Вам необходимо создать enum, в котором будут такие варианты передвижения как:
самолет, поезд, автомобиль, велосипед и пешком. Вам необходимо создать такой enum,
в котором в качестве конструктора задавалась бы продолжительность поездки, в зависимости от способа передвижения.
Значение будет задаваться в часах (дробное число, можно задать приближённое значение, либо попробовать найти лучший вариант на google maps).
Помимо этого, в этом enum необходимо создать метод для получения информации о продолжительности поездки в днях, часах, минутах и секундах (разными методами)
*/


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public enum MovementType {
    PLANE(3.33),
    TRAIN(5.00),
    CAR(6.00),
    BICYCLE(35.00),
    BY_FOOT(118.00);

    private final double duration;

    MovementType(double duration) {
        this.duration = duration;
    }

    public double getDurationInHours() {
        return duration;
    }

    public double getDurationInDays() {
        return duration / 24;
    }

    public double getDurationInMinutes() {
        return duration * 60;
    }

    public double getDurationInSeconds() {
        return duration * 3600;
    }
}
