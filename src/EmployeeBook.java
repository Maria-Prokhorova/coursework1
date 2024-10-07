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
        } else System.out.println("Нельзя добавить сотрудника в книгу учёта, закончилось место");
    }

    // Метод удаления сотрудника из книги учёта
    public void deleteWorker(int id) {
        for (int i = 0; i < workers.length; i++) {
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
        for (Employee worker : workers) {
            if (worker.getId() == id) {
                return worker;
            }
        }
        return null;
    }

    // Метод печати списка всех сотрудников со всеми имеющимися по ним данными
    public void printWorkers() {
        for (Employee worker : workers) {
            System.out.println(worker);
        }
    }

    //Метод подсчета сумму затрат на ЗП в месяц
    public int calculateSumSalary() {
        int sum = 0;
        for (Employee worker : workers) {
            if (worker != null) {
                sum = sum + worker.getSalary();
            }
        }
        return sum;
    }

    //Метод поиска сотрудника с минимальной ЗП
    public Employee minSalary() {
        int min = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && workers[i].getSalary() < min) {
                min = workers[i].getSalary();
                k = i;
            }
        }
        return workers[k];
    }

    // Метод поиска сотрудника с максимальной ЗП
    public Employee maxSalary() {
        int max = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && workers[i].getSalary() > max) {
                max = workers[i].getSalary();
                k = i;
            }
        }
        return workers[k];
    }

    //Метод подсчета среднего значения зарплат
    public double averageSalary() {
        int sum = this.calculateSumSalary();
        return (double) sum / workers.length;
    }

    //Метод печати ФИО всех сотрудников
    public void printFullNameWorker() {
        for (int i = 0; i < workers.length; i++) {
            System.out.println("ФИО " + (i + 1) + " сотрудника - " + workers[i].getFullName());
        }
    }

    //Метод индексации зарплаты сотрудников
    public void indexationSalary(int percent) {
        for (Employee worker : workers) {
            worker.setSalary(worker.getSalary() + (worker.getSalary() * percent) / 100);
        }
    }

    // Метод поиска сотрудника с минимальной ЗП в отделе
    public Employee minSalary(int department) {
        int min = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && workers[i].getDepartment() == department && workers[i].getSalary() < min) {
                min = workers[i].getSalary();
                k = i;
            }
        }
        return workers[k];
    }

    // Метод поиска сотрудника с максимальной ЗП в отделе
    public Employee maxSalary(int department) {
        int max = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < workers.length; i++) {
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
        for (Employee worker : workers) {
            if (worker != null && worker.getDepartment() == department) {
                sum = sum + worker.getSalary();
            }
        }
        return sum;
    }

    //Метод подсчета среднего значения зарплат по отделу
    public double averageSalary(int department) {
        int quantityPeople = 0;
        for (Employee worker : workers) {
            if (worker != null && worker.getDepartment() == department) {
                quantityPeople++;
            }
        }
        int sum = this.calculateSumSalary(department);
        return (double) sum / quantityPeople;
    }

    //Метод индексации зарплаты сотрудников отдела
    public void indexationSalary(int percent, int department) {
        for (Employee worker : workers) {
            if (worker != null && worker.getDepartment() == department) {
                worker.setSalary(worker.getSalary() + (worker.getSalary() * percent) / 100);
            }
        }
    }

    // Метод печати списка всех сотрудников со всеми имеющимися по ним данными
    public void printWorkersInDepartment(int department) {
        System.out.println("Список сотрудников " + department + " отдела:");
        for (Employee worker : workers) {
            if (worker != null && worker.getDepartment() == department) {
                System.out.println("ФИО - " + worker.getFullName() + ", ЗП - " + worker.getSalary());
            }
        }
    }

    //Метод поиска сотрудников с ЗП меньше заданного числа
    public void printWorkersMinSalary(int number) {
        System.out.println("Список сотрудников с ЗП ниже " + number);
        for (Employee worker : workers) {
            if (worker != null && worker.getSalary() < number) {
                System.out.println("ФИО - " + worker.getFullName() + ", ЗП - " + worker.getSalary() +
                        ", ID - " + worker.getId());
            }
        }
    }

    //Метод поиска сотрудников с ЗП больше заданного числа
    public void printWorkersMaxSalary(int number) {
        System.out.println("Список сотрудников с ЗП выше " + number);
        for (Employee worker : workers) {
            if (worker != null && worker.getSalary() >= number) {
                System.out.println("ФИО - " + worker.getFullName() + ", ЗП - " + worker.getSalary() +
                        ", ID - " + worker.getId());
            }
        }
    }
}
