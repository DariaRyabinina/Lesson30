# language: ru
@allTest
@less27
Функционал: работа Less27 https:www.sberbank

  Сценарий: проверка страницы «Сбербанк» - Частным клиентам
    * выполнен переход на https: www_sberbank
    * проверка названия титула "«Сбербанк» - Частным клиентам"

  Сценарий: проверка страницы «Сбербанк» - Подбор вкладов
    * выполнен переход на вкладку "Вклады"
    * проверка названия титула "«Сбербанк» - Подбор вкладов"

  Сценарий: вкладка  «Подобрать вклад»
    * выполнен переход на меню "Подобрать вклад"
    * проверка отображения чек-боксов
      | Хочу снимать   |
      | Хочу пополнять |
      | Онлайн         |
      | Я - пенсионер  |
    * проверка чек-бокса «Онлайн»
    * проверка отражения вкладов
      | Вклад Сохраняй |
      | Вклад Пополняй |
      | Вклад Управляй |

    * установка чек-боксов
      | Хочу снимать   |
      | Хочу пополнять |
    * проверка отображения вкладов Отсутствуют
      | Вклад Сохраняй |
      | Вклад Пополняй |
    * проверка отражения вкладов
      | Вклад Управляй |
    * нажать кнопку Подробнее

  Сценарий: вкладка Вклад Управляй
    * переключение на новое окно
    * проверка названия титула "«Сбербанк» - Вклад Управляй"
    * проверка надписи Вклад Управляй.



