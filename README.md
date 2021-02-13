# Mobile labs #
  
by Ilnytsky Vladyslav IO-83  

### Last version ###  
https://drive.google.com/file/d/1wDkD9NtCowJoVWkc2IH7Bj8nbSuHV1A0/view?usp=sharing  
  
## Project main/source directories ##  
  
app/src/main/java/ua.kpi.comsys.io8312/  
app/src/main/res  
  
## Lab 1.1 ##  
  
Вывод данных на экран  
  
Ссылка на комит: https://github.com/Ekrosrb/MobileLabs/commit/7f1bf836463cf24b8059348fae2fe49d026f38e1  
  
## Lab 1.2 ##
  
app/src/main/java/ua.kpi.comsys.io8312/playground/  
  
Класс TimeVI для хранения времени.  
Тест созданых методов:  
toString() - вывод времени в формате hh:mm:ss a  
TimeVI addTime(TimeVI time) - возвращает результат сложения времени current + time  
TimeVI addTime(TimeVI time1, TimeVI time2) - возвращает результат сложения времени time1 + time2  
TimeVI subTime(TimeVI time) - возвращает разницу времени current - time  
TimeVI subTime(TimeVI time1, TimeVI time2) - возвращает разницу времени time1 - time2  
  
Вывод результатов теста на экран.  
  
Задание 1  
Ccылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/9e2110a6219b7c497dbf832a5be7cf9f24021f54  
Задание 2  
Ccылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/de7301a3e6d4372dfeb8bb4025083ec4d4c5c058  

## Lab 2 ##  
  
Всё задание из 2 лабораторной.  
  
Код первой лабораторной был перенесен в Lab1Fragment.  
   
Класс adapters/LabAdapter для управления вкладками.  
Классы Lab1Fragment и Lab2Fragment для настройки и отображения содерщимого вкладок с первой и второй лабораторной соотвецтвенно.  
  
Ссылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/b18eb8287d17206298c204bcd075b974697a0c5e  
  
Иконки для вкладок: https://github.com/Ekrosrb/MobileLabs/commit/b31312039ceb00ff322987cdd8943bd1200c7a36  
  
## Lab 3 ##   
  
Добавлена вкладка Lab3Fragment.  
Классы Movie, MovieDto, Search, а так же библиотека gson - для парсинга и работы с json данными.  
Класс MyFileReader - file in/out stream.  
Класс MovieAdapter - управление и размещение вкладок с фильмами согласно заданию.  
  
XML:  
list_item - вид одной вкладки с фильмом.  
lab3_fragment - вкладка с 3 лабораторной.  
  
Ссылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/1eaea20c1b2fedd16fb752bea9cd619daa5cec29  

## Lab 4 ##
  
Добавлен activity AddMovieActivity для добавления элементов в список.  
Добавлен activity MovieDetailInfoActivity для отображения подробной информации о фильме.  
Добавлена поисковая строка для фильтрации элементов в списке.  
Добавлено диалоговое окно для удаления элемента.  
  
Классы:  
  
Global - глобальные переменные для передачи между activities (самый простой и удобный способ).  
MovieFilter - внутренний класс в MovieAdapter для фильтрации элементов в списке.  
  
XML:  
  
activity_add_movie - внешний вид складки для добавления элементов.  
activity_item_all_info - внешний вид вкладки с информацией о фильме.  
  
Существенные модификации:  
  
Lab3Fragment - добавлено много обработчиков событий, а так же исправлен алгоритм загрузки вкладки.  
MovieAdapter - добавлен внутренний класс и код для фильтрации элементов списка, а так же событие отображения сообщения в случае отсутствия совпадений.  
MyFileReader - добавлена возможность добавлять и удалять элементы в файл. (После перезапуска приложения все добавленные элементы списка остаются).  
  
Ссылка на коммит:  
  
Для отображения диалогового окна для удаления элемента, нужно использовать долгое нажатие на этот элемент.  
  
Для отображения детальной информации об элементе, нужно нажать на этот элемент.  
  