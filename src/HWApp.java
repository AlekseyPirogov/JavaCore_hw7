// Дисциплина: Java Core для тестировщиков
// Домашнее задание №7 "Промежуточный проект"
// Студент: Алексей Пирогов
// Дата: 23.03.2022

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

// Задание:
// 1. Реализовать корректный вывод информации о текущей погоде. Создать класс WeatherResponse и десериализовать
// ответ сервера. Выводить пользователю только текстовое описание погоды и температуру в градусах Цельсия.
// 2. Реализовать корректный выход из программы.
// 3. Реализовать вывод погоды на следующие 5 дней в формате:
//    | В городе CITY на дату DATE ожидается WEATHER_TEXT, температура - TEMPERATURE |
// Где CITY, DATE, WEATHER_TEXT и TEMPERATURE - уникальные значения для каждого дня.

// Примечание:
// Для корректной работы программы могут понадобиться библиотеки okkhttp-4.8.1.jar, kotlin-stdlib-1.4.0.jar,
// jackson-databind-2.12.5.jar, . Репозиторий: https://mvnrepository.com/

public class HWApp {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nПрограмма позволяет получить прогноз с использованием сервиса \"Яндекс.Погода.\"" +
                    "\nДля получения погоды используйте географические координаты населенного пункта." +
                    "\nНапример, для Санкт-Петербугра: 59.9386, 30.3141; для Москвы: 55.7558, 37.6176." +
                    "\nДля выхода из программы введите команду \"exit\"");
            System.out.println("\nВведите широту (от 0° до 90° - положительные значения для северного полушария, а отрицательные для южного):");
            String lat = scanner.nextLine();
            closeProgram(lat);
            System.out.println("Введите долготу (от  0° до 180° - положительные к востоку от нулевого меридиана, а отрицательные для западного направления):");
            String lon = scanner.nextLine();
            closeProgram(lon);

            System.out.println("Введите количество дней для формирования прогноза (не более 7 дней):");
            String countDay = scanner.nextLine();
            do {
                if(Integer.parseInt(countDay) > 0 && Integer.parseInt(countDay) <= 7)
                    break;
                else
                    System.out.println("Некорректный ввод данных, введите число от 1 до 7:");
                countDay = scanner.nextLine();
            } while (true);

            // Подкласса HttpURLConnection, произвольный класс от URLConnection и поддерживает соединение по
            // сетевому протоколу HTTP.
            OkHttpClient okHttpClient = new OkHttpClient();

            // Создание объекта класса HttpUrl c использованием паттерна проектироания "строитель"
            // для тестирования API Яндекс.Погода:
            HttpUrl urlYandex = new HttpUrl.Builder()
                    .scheme("https")                                    /* схема подключения: потокол HTTPS */
                    .host("api.weather.yandex.ru")                      /* адрес хоста: в формате DNS-имени */
                    .addPathSegment("v2")                               /* сегмент пути: версия API */
                    .addPathSegment("forecast")                         /* сегмент пути: прогноз */
                    .addQueryParameter("lat", lat)                /* аргумент №1 - координата широты */
                    .addQueryParameter("lon", lon)                /* аргумент №2 - координата долготы */
                    .addQueryParameter("lang", "ru_RU")     /* аргумент №3 - язык ответа */
                    .addQueryParameter("limit", countDay)         /* аргумент №4 - срок прогноза от 1 до 7 дней */
                    .addQueryParameter("hours", "false")    /* аргумент №5 - возворащается почасовой (true) */
                    .addQueryParameter("extra", "false")    /* аргумент №6 - расширенная информация об осадках */
                    .build();

            // Формирование запроса: добавление заголовка к запросу
            Request request = new Request.Builder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-Yandex-API-Key", "c7aafa93-6e95-48a8-aa5d-f24ea875a8c4")
                    .url(urlYandex)
                    .build();

            // Вывод итогового запроса в виде строки:
            System.out.println("\nЗапрос ресурса:\t" + urlYandex + "\n");

            // Тело ответа от сервера:
            String responceServer = okHttpClient.newCall(request).execute().body().string();
            //printResponse(responceServer);

            // Десереализация JSON:
            ObjectMapper mapper = new ObjectMapper();
            StringReader reader = new StringReader(responceServer);
            WeatherResponse weatherResponse = mapper.readValue(reader, WeatherResponse.class);

            // Ввывод информации о погоде
            try {
                printWeather(weatherResponse);
            } catch (NullPointerException e) {
                e.printStackTrace();
                continue;
            }

            System.out.println("Для выхода введите \"exit\", а для продолжения любую клавишу...");
            String exitkey = scanner.nextLine();
            closeProgram(exitkey);
        }
        while (true);
    }

    // Метод для завершения работы и выхода их цикла работы программы
    public static void closeProgram(String exitKey) {
        if (exitKey.toLowerCase().equals("exit")) {
            System.out.println("Завершаю работу...");
            System.exit(0);
        }
    }

    // Метод для вывода погоды
    public static void printWeather(WeatherResponse weatherResponse) throws NullPointerException {
                                                       // 012345678910
                                                        // 2022-03-23
        System.out.println("\n\nПо состоянию на " + weatherResponse.getNow_dt().substring(8,10) + "."
                            + weatherResponse.getNow_dt().substring(5,7) + ":");
        int countDay = weatherResponse.getForecasts().size();
        //System.out.println(weatherResponse.getGeo_object().toString());
        for(int i = 0; i < countDay; i++) {
            System.out.println("В городе " + weatherResponse.getGeo_object().getLocality().getName() +
                    " на дату " + weatherResponse.getForecasts().get(i).getDate() +
                    " ночью: " + weatherResponse.getForecasts().get(i).getParts().getNightShort().getCondition() +
                    ", температура " + weatherResponse.getForecasts().get(i).getParts().getNightShort().getTemp() + "°C");
            System.out.println("В городе " + weatherResponse.getGeo_object().getLocality().getName() +
                    " на дату " + weatherResponse.getForecasts().get(i).getDate() +
                    " днём: " + weatherResponse.getForecasts().get(i).getParts().getDayShort().getCondition() +
                    ", температура " + weatherResponse.getForecasts().get(i).getParts().getDayShort().getTemp() + "°C");
        }
    }

    // Метод для вывода запроса в форматированном виде
    public static void printResponse(String responseServer){
        // Форматированный вывод ответа от сервера:
        System.out.println("\n\nОтвет от сервера в формате JSON, адаптирован для чтения:");
        char[] charBuffer = responseServer.toCharArray();
        int paddingLeft = -2;   // Переменная для управления форматированием вывода

        for (int i = 0; i < charBuffer.length; i++) {
            switch (charBuffer[i]) {
                case '{':
                    if(i != 0 && charBuffer[i-1] == ',') {
                        paddingLeft += 2;
                        paddingLeft(paddingLeft);
                        System.out.print(charBuffer[i] + "\n");
                        for (int t = 0; t < paddingLeft; t++)
                            System.out.print("\t");
                    } else {
                        System.out.print(charBuffer[i] + "\n");
                        paddingLeft += 2;
                        paddingLeft(paddingLeft);
                    }
                    break;
                case ',':
                    if (charBuffer[i+1] == '"') {
                        System.out.print(charBuffer[i] + "\n");
                        paddingLeft(paddingLeft);
                    } else if (charBuffer[i+1] == '{') {
                        System.out.print(charBuffer[i] + "\n");
                        paddingLeft(paddingLeft);
                    } else {
                        System.out.print(charBuffer[i]);
                    }
                    break;
                case '}':
                    System.out.print("\n");
                    paddingLeft(paddingLeft);
                    System.out.print(charBuffer[i]);
                    paddingLeft -= 2;
                    break;
                default:
                    System.out.print(charBuffer[i]);
                    break;
            }
        }
    }

    // Метод для вывода отступа слева, форматирования текста
    public static void paddingLeft(int paddingLeft) {
        for (int t = 0; t < paddingLeft; t++)
            System.out.print("\t");
    }

}
