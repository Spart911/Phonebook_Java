import java.util.*;

public class Phonebook {

    private final HashMap<String, List<String>> contacts;

    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            List<String> phoneNumbers = contacts.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }

    public List<String> searchContact(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());
    }


    public void removeContact(String name) {
        contacts.remove(name);
    }

    public void printPhonebook() {
        // Создаем список записей (имя - количество телефонов) для сортировки
        List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(contacts.entrySet());

        // Сортируем список по убыванию количества телефонов
        sortedList.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированный результат
        for (Map.Entry<String, List<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.addContact("Иван", "123456789");
        phonebook.addContact("Иван", "133436789");
        phonebook.addContact("Петя", "987654321");
        phonebook.addContact("Иван", "555555555");
        phonebook.addContact("Петя", "111111111");

        System.out.println("Поиск по имени: Иван: " + phonebook.searchContact("Иван"));
        System.out.println("Поиск по имени: Петя: " + phonebook.searchContact("Петя"));

        phonebook.printPhonebook();

        phonebook.removeContact("Петя");

        System.out.println("После удаления контакта: Петя:");
        phonebook.printPhonebook();
    }
}
