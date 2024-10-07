public class EmployeeBook {

    // поля класса
    private Employee[] workers;
    private int size;

    // конструктор
    public EmployeeBook() {
        this.workers = new Employee[10];
    }

    // Метод добавления сотрудника в книгу учёта
    public void addWorker(String fullName, int department, int salary) {
        if (workers[size] == null && size < workers.length) {
            Employee newWorker = new Employee(fullName, department, salary);
            workers[size++] = newWorker;
        } else {
            System.out.println("Нельзя добавить сотрудника в книгу учёта, закончилось место");
        }
    }

    // Метод удаления сотрудника из книги учёта
    public void deleteWorker(int id) {
        for (int i = 0; i < size; i++) {
            if (workers[i].getId() == id) {
                System.arraycopy(workers, i + 1, workers, i, size - i - 1);
                workers[size - 1] = null;
                size--;
                return;
            }
        }
    }

    //Метод поиска сотрудника по ID
    public Employee findWorkerID(int id) {
        for (int i = 0; i < size; i++) {
            if (workers[i].getId() == id) {
                return workers[i];
            }
        }
        return null;
    }

    // Метод печати списка всех сотрудников со всеми имеющимися по ним данными
    public void printWorkers() {
        for (int i = 0; i < size; i++) {
            if (workers[i] != null) {
                System.out.println(workers[i]);
            }
        }
    }

    //Метод подсчета сумму затрат на ЗП в месяц
    public int calculateSumSalary() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (workers[i] != null) {
                sum = sum + workers[i].getSalary();
            }
        }
        return sum;
    }

    //Метод поиска сотрудника с минимальной ЗП
    public Employee findMinSalary() {
        int min = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getSalary() < min) {
                min = workers[i].getSalary();
                k = i;
            }
        }
        return workers[k];
    }

    // Метод поиска сотрудника с максимальной ЗП
    public Employee findMaxSalary() {
        int max = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getSalary() > max) {
                max = workers[i].getSalary();
                k = i;
            }
        }
        return workers[k];
    }

    //Метод подсчета среднего значения зарплат
    public double averageSalary() {
        int sum = calculateSumSalary();
        return (double) sum / size;
    }

    //Метод печати ФИО всех сотрудников
    public void printFullNameWorker() {
        for (int i = 0; i < size; i++) {
            if (workers[i] != null) {
                System.out.println("ФИО " + (i + 1) + " сотрудника - " + workers[i].getFullName());
            }
        }
    }

    //Метод индексации зарплаты сотрудников
    public void indexationSalary(int percent) {
        for (int i = 0; i < size; i++) {
            if (workers[i] != null) {
                workers[i].setSalary(workers[i].getSalary() + (workers[i].getSalary() * percent) / 100);
            }
        }
    }

    // Метод поиска сотрудника с минимальной ЗП в отделе
    public Employee findMinSalary(int department) {
        int min = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department && workers[i].getSalary() < min) {
                min = workers[i].getSalary();
                k = i;
            }
        }
        return workers[k];
    }

    // Метод поиска сотрудника с максимальной ЗП в отделе
    public Employee findMaxSalary(int department) {
        int max = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department && workers[i].getSalary() > max) {
                max = workers[i].getSalary();
                k = i;
            }
        }
        return workers[k];
    }

    //Метод подсчета сумму затрат на ЗП в месяц на отдел
    public int calculateSumSalary(int department) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department) {
                sum = sum + workers[i].getSalary();
            }
        }
        return sum;
    }

    //Метод подсчета среднего значения зарплат по отделу
    public double averageSalary(int department) {
        int quantityPeople = 0;
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department) {
                quantityPeople++;
            }
        }
        int sum = calculateSumSalary(department);
        return (double) sum / quantityPeople;
    }

    //Метод индексации зарплаты сотрудников отдела
    public void indexationSalary(int percent, int department) {
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department) {
                workers[i].setSalary(workers[i].getSalary() + (workers[i].getSalary() * percent) / 100);
            }
        }
    }

    // Метод печати списка всех сотрудников со всеми имеющимися по ним данными
    public void printWorkersInDepartment(int department) {
        System.out.println("Список сотрудников " + department + " отдела:");
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department) {
                System.out.println("ФИО - " + workers[i].getFullName() + ", ЗП - " + workers[i].getSalary());
            }
        }
    }

    //Метод поиска сотрудников с ЗП меньше заданного числа
    public void printWorkersMinSalary(int number) {
        System.out.println("Список сотрудников с ЗП ниже " + number);
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getSalary() < number) {
                System.out.println("ФИО - " + workers[i].getFullName() + ", ЗП - " + workers[i].getSalary() +
                        ", ID - " + workers[i].getId());
            }
        }
    }

    //Метод поиска сотрудников с ЗП больше заданного числа
    public void printWorkersMaxSalary(int number) {
        System.out.println("Список сотрудников с ЗП выше " + number);
        for (int i = 0; i < size; i++) {
            if (workers[i] != null && workers[i].getSalary() >= number) {
                System.out.println("ФИО - " + workers[i].getFullName() + ", ЗП - " + workers[i].getSalary() +
                        ", ID - " + workers[i].getId());
            }
        }
    }
}
