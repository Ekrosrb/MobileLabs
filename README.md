# Mobile labs #
  
by Ilnytsky Vladyslav IO-83  

### Last version ###  
https://drive.google.com/file/d/1yzuPQUyRuySKLEd6vAv_8ipArk8vlrF6/view?usp=sharing
  
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
  
Ссылка на коммит: https://github.com/Ekrosrb/MobileLabs/pull/3/commits/61f6256f9cdbbd0043579692079a1e6ec5eaccd6  
  