5 лаба

Структура лабораторной работы:

![image](https://github.com/user-attachments/assets/7a6b397f-a84c-4273-b9db-4cc42ebda397)
- Command — это интерфейс или абстрактный класс, который объявляет метод execute(). Этот метод определяет операцию, которую необходимо выполнить.

- Concrete Command — это реализации интерфейса Command. Каждая конкретная команда инкапсулирует конкретный запрос и привязывает его к получателю, вызывая соответствующую операцию на получателе.

- Receiver — это объект, который выполняет фактическую операцию во время выполнении команды. Receiver знает, как выполнить запрос.

Managers:
- Console - обработчик ввода команд
	постоянно ожидает ввод команд - ввод перенаправляется в CommandManager
- CommandManager - хранит CommandList HashMap<String, BaseCommand> со всеми командами
	обесечивает связь между Console и всеми коммандами
	исполнение обеспечивает метод doCommand(String input, CollectionManager collectionManager, Reciever reciever)
- CollectionManager - хранит LinkedHashSet
	работа с коллекцией

Commands:

- Все комманды наследуются интерфейса от BaseCommand:
	execute, getName, getDescription

Принцип работы:

- Console ожидает ввода

- Console парсит строку и кидает аргументы в CommandManager (
	String out = commandManager.doCommand(input, collectionManager, reciever)

- CommandManager определяет комманду и ключи 

- CommandManager получаем нужную нам команду и запускаем ее со всеми аргументами

- Далее каждая команда выполняется так, как её прописали


Работоспособность программы:

![image](https://github.com/user-attachments/assets/46390ca8-017c-4289-98cb-67b479b2d72d)

- Подгружает локальную переменную и выводит, что в неё лежит.

![image](https://github.com/user-attachments/assets/d02dc665-915d-4497-8052-07ff943ce746)

- Обновляет коллекции внутри локальной переменной.

![image](https://github.com/user-attachments/assets/bba20159-31f3-490d-ad18-055572c8e0bb)
  
- Добавляет новые коллекции внутри локальной переменной.

  ![image](https://github.com/user-attachments/assets/42e37317-e4b1-4aa0-918a-3b687ddb0e29)

- Удаляет коллекции внутри локальной переменной.

  ![image](https://github.com/user-attachments/assets/dedca3ba-6c3b-42e7-ba18-0a0b1976dec7)

- При команде execute_script проверяет на рекурсию, при команде save сохраняет коллекцию в файл.
