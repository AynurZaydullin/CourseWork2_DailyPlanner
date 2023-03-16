import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DailyPlanner {
    private static final Map<Integer, Repeatability> actualTask = new HashMap<>();

    public static void addTask(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите название задачи: ");
        String title = scanner.nextLine();
        System.out.println("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.println("Введите повторяемость задачи: однократная - 0, " +
                "ежедневная: - 1.");
        int occurrence = scanner.nextInt();
        System.out.println("Введите тип задачи:");
        TaskType taskType = TaskType.values()[scanner.nextInt()];
        System.out.println("Введите дату в формате: dd.MM.yyyy HH:mm");
        char[] dataArr;
        scanner.nextLine();
        dataArr = scanner.nextLine().toCharArray();
        char[] dataChar = new char[15];
        dataChar = dataArr;
        System.out.println(dataChar);
//        LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
//        DailyTask dailyTask = new DailyTask(title, description, taskType, eventDate);
//        Repeatability task = null;
//        createTask(occurrence, title, description, taskType, eventDate);
//        System.out.println(eventDate);
    }

    private static void createEvent(Scanner scanner, String title, String description, TaskType taskType, int occurance) {
        LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        Repeatability task = null;
        createTask(occurance, title, description, taskType, eventDate);
    }
        private static void createTask(int occurrence, String title, String description, TaskType taskType, LocalDateTime localDateTime)  { //throws WrongInputException
        if (occurrence == 0) {
            OnceTask onceTask = new OnceTask(title, description, taskType, localDateTime);
            actualTask.put(onceTask.getId(), onceTask);
        }
        else if(occurrence == 1) {
            DailyTask task = new DailyTask(title, description, taskType, localDateTime);
            actualTask.put(task.getId(), task);
            System.out.println("1");
        }
        }

//    public static void printTask() {
//        System.out.print(dailyTask);
//    }

    public static void getTasksByDay(Scanner scanner) {
        String date = scanner.next();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }
    public static List<Repeatability> findTasksByDate(Scanner scanner) {
        System.out.println("Введите дату в формате: dd.MM.yyyy");
        String date = scanner.next();
        LocalDateTime data = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd.MM"));
        List<Repeatability> tasks = new ArrayList<>();
        for (Repeatability task : actualTask.values()) {
            if (task.compareParametersOfDate(data)) {
                tasks.add(task);
            }
        }
        return tasks;
    }
}
