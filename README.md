# Mobile labs #
  
by Ilnytsky Vladyslav IO-83  

### Last version ###  
  
Лабораторная 6 вносит много изменений поэтому её версия приложения доступна отдельно.  
  
Лабораторные 1-5:  
https://drive.google.com/file/d/1P_VecuJKICN1quRu1Ok9izjhsarXcuc1/view?usp=sharing  
  
Лабораторная 6/7:  
https://drive.google.com/file/d/1Q2ROr_oT__4YUZPRa8u1sM1nzigP1WDm/view?usp=sharing  
  
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
  
Ссылка на коммит с исправлением (случайные значения затрудняли проверку на корректную работу программы, т.е числовые значения в разных заданиях при выводе не соответствовали друг другу, так как для следующего задания случайные значения оценок генерировались заново):  
  
https://github.com/Ekrosrb/MobileLabs/commit/e0c4b147ce9dbc1f6a916cc3989a61d92d23c547  
  
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
  
#### XML: ####  
list_item - вид одной вкладки с фильмом.  
lab3_fragment - вкладка с 3 лабораторной.  
  
Ссылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/1eaea20c1b2fedd16fb752bea9cd619daa5cec29  

## Lab 4 ##
  
Добавлен activity AddMovieActivity для добавления элементов в список.  
Добавлен activity MovieDetailInfoActivity для отображения подробной информации о фильме.  
Добавлена поисковая строка для фильтрации элементов в списке.  
Добавлено диалоговое окно для удаления элемента.  
  
#### Классы: ####  
  
Global - глобальные переменные для передачи между activities (самый простой и удобный способ).  
MovieFilter - внутренний класс в MovieAdapter для фильтрации элементов в списке.  
  
#### XML: ####  
  
activity_add_movie - внешний вид складки для добавления элементов.  
activity_item_all_info - внешний вид вкладки с информацией о фильме.  
  
#### Существенные модификации: ####  
  
Lab3Fragment - добавлено много обработчиков событий, а так же исправлен алгоритм загрузки вкладки.  
MovieAdapter - добавлен внутренний класс и код для фильтрации элементов списка, а так же событие отображения сообщения в случае отсутствия совпадений.  
MyFileReader - добавлена возможность добавлять и удалять элементы в файл. (После перезапуска приложения все добавленные элементы списка остаются).  
  
Ссылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/29ce023c520d62bebecf2e91e8b5b37ec9e4a0a2  
  
Для отображения диалогового окна для удаления элемента, нужно использовать долгое нажатие на этот элемент.  
  
Для отображения детальной информации об элементе, нужно нажать на этот элемент.  

## Lab 5 ##
  
Добавлена вкладка с менеджером размещения изображений за заданным шаблоном.  
  
#### Классы ####  
  
ImageAdapter - класс для размещения изображений за шаблоном.  
Lab5Fragment - класс управления 4 вкладкой.  
ImageItem - класс для хранения ссылок на изображения в галереи для 1-го элемента списка.  
ImageList - класс хранит элементы списка (ImageItem).  
  
#### XML ####  
  
lab5_fragment.xml - размещение компонентов в 4 вкладке.  
image_manager_list_item.xml - пустые формы для вставки изображений (1 элемент списка, 6 изображений за шаблоном).  
  
Ссылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/824f456b666f033f8e0046c2108a9bf84f5b6345  
  
## Lab 6 ##  
  
Теперь будут 2 ссылки на скачивание приложения, одна для старой версии и одна для новой (6 лабораторная).  
  
Переделаны 3 и 4 вкладки.  
3 вкладка(фильмы): Теперь все данные подгружаются при помощи http запросов и API с информацией про фильмы.
То же самое с детальной информацией.  
4 вкладка(изображения): Все изображения загружаются при помощи http запросов.  
  
Ненужные классы с прошлых лабораторных помечены как @Deprecated и больше не используются, а так же часть кода была закомментирована.  
  
#### Классы ####  
  
RecyclerMovieAdapter и RecyclerView - замена старым ListView и MovieAdapter. Более производительная версия.  
ImageModel - класс с информацией о загружаемом изображении. Для оптимизации содержит только 1 поле со ссылкой на изображение, остальная информация с json игнорируется.  
MovieModel - замена классам Movie, Search, MovieDto.  
Async, AsyncImages, AsyncMovieInfo, AsyncMoviesInfo - классы для отправки асинхронных http запросов.  
  
Класс MyFileReader устарел и больше не используется, поскольку нет нужды загружать данные из хранилища.  
  
#### XML ####  
  
progress_animation.xml - анимация при загрузке изображения.  
  
Ссылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/310c287a101186558c95eb94d1c4579f7c3d1e68  

## Lab7 ##
  
Добавлено сохранение данных, сохраненные данные можно отобразить если нет подключения к интернету. Точно так же с изображениями - они сохраняются в кеш.  
  
Для записи данных используется библиотека Realm.  
Для сохранения и отображения изображений - Picasso.  
  
Ссылка на коммит: https://github.com/Ekrosrb/MobileLabs/commit/7f46136555f6618df1e95af090f4c8cd3e1dd4dd  
  
