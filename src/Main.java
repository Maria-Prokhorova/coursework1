public class Main {
    public static void main(String[] args) {

        Employee[] workers = new Employee[10];
        workers[0] = new Employee("Прохорова М.В.", 2, 55_000);
        workers[1] = new Employee("Телешун Н.И.", 2, 35_000);
        workers[2] = new Employee("Екимов А.П.", 1, 80_000);
        workers[3] = new Employee("Пономаренко А.А.", 3, 40_000);
        workers[4] = new Employee("Прохорова М.В.", 5, 65_300);
        workers[5] = new Employee("Беленкова В.С.", 4, 35_700);
        workers[6] = new Employee("Лапоногова О.Р.", 4, 60_000);
        workers[7] = new Employee("Дорохова Т.Ю.", 1, 65_300);
        workers[8] = new Employee("Попов А.А.", 1, 70_500);
        workers[9] = new Employee("Иванов В.П.", 3, 45_000);

        System.out.println();
        printWorkers(workers);

        System.out.println();
        int sumSalary = calculateSumSalary(workers);
        System.out.println("Сумма затрат на ЗП в месяц - " + sumSalary);

        Employee minSalaryWorker = minSalary(workers);
        System.out.println("Минимальная зарплата: " + minSalaryWorker);

        Employee maxSalaryWorker = maxSalary(workers);
        System.out.println("Максимальная зарплата: " + maxSalaryWorker);

        int averageSalaryWorker = averageSalary(workers);
        System.out.println("Среднее значение зарплат в компании - " + averageSalaryWorker);

        System.out.println();
        printFullNameWorker(workers);

        System.out.println();
        indexationSalary(workers, 10);
        printWorkers(workers);

        System.out.println();
        minSalaryWorker = minSalary(workers, 1);
        System.out.println("Минимальная зарплата в отделе - " + minSalaryWorker);

        maxSalaryWorker = maxSalary(workers, 1);
        System.out.println("Максимальная зарплата в отделе - " + maxSalaryWorker);

        int sumSalaryInDepartment = calculateSumSalary(workers, 4);
        System.out.println("Сумма затрат на ЗП в месяц на отдел - " + sumSalaryInDepartment);

        int averageSalaryWorkerInDepartment = averageSalary(workers, 1);
        System.out.println("Среднее значение зарплат в отделе - " + averageSalaryWorkerInDepartment);

        System.out.println();
        indexationSalary(workers, 5, 3);
        printWorkersInDepartment(workers, 5);

        System.out.println();
        int parameter = 55_700;
        printWorkersMinSalary(workers, parameter);

        System.out.println();
        parameter = 60_000;
        printWorkersMaxSalary(workers, parameter);

    }

    // Метод печати списка всех сотрудников со всеми имеющимися по ним данными
    public static void printWorkers(Employee[] workers) {
        System.out.println("Список сотрудников компании:");
        for (Employee worker : workers) {
            System.out.println(worker);
        }
    }

    //Метод подсчета сумму затрат на ЗП в месяц
    public static int calculateSumSalary(Employee[] workers) {
        int sum = 0;
        for (Employee worker : workers) {
            if (worker != null) {
                sum = sum + worker.getSalary();
            }
        }
        return sum;
    }

    //Метод поиска сотрудника с минимальной ЗП
    public static Employee minSalary(Employee[] workers) {
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
    public static Employee maxSalary(Employee[] workers) {
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
    public static int averageSalary(Employee[] workers) {
        int sum = calculateSumSalary(workers);
        return sum / workers.length;
    }

    //Метод печати ФИО всех сотрудников
    public static void printFullNameWorker(Employee[] workers) {
        for (int i = 0; i < workers.length; i++) {
            System.out.println("ФИО " + (i + 1) + " сотрудника - " + workers[i].getFullName());
        }
    }

    //Метод индексации зарплаты сотрудников
    public static void indexationSalary(Employee[] workers, int percent) {
        for (Employee worker : workers) {
            worker.setSalary(worker.getSalary() + (worker.getSalary() * percent) / 100);
        }
    }

    // Метод поиска сотрудника с минимальной ЗП в отделе
    public static Employee minSalary(Employee[] workers, int department) {
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
    public static Employee maxSalary(Employee[] workers, int department) {
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
    public static int calculateSumSalary(Employee[] workers, int department) {
        int sum = 0;
        for (Employee worker : workers) {
            if (worker != null && worker.getDepartment() == department) {
                sum = sum + worker.getSalary();
            }
        }
        return sum;
    }

    //Метод подсчета среднего значения зарплат по отделу
    public static int averageSalary(Employee[] workers, int department) {
        int quantityPeople = 0;
        for (Employee worker : workers) {
            if (worker != null && worker.getDepartment() == department) {
                quantityPeople++;
            }
        }
        int sum = calculateSumSalary(workers, department);
        return sum / quantityPeople;
    }

    //Метод индексации зарплаты сотрудников отдела
    public static void indexationSalary(Employee[] workers, int percent, int department) {
        for (Employee worker : workers) {
            if (worker != null && worker.getDepartment() == department) {
                worker.setSalary(worker.getSalary() + (worker.getSalary() * percent) / 100);
            }
        }
    }

    // Метод печати списка всех сотрудников со всеми имеющимися по ним данными
    public static void printWorkersInDepartment(Employee[] workers, int department) {
        System.out.println("Список сотрудников " + department + " отдела:");
        for (Employee worker : workers) {
            if (worker != null && worker.getDepartment() == department) {
                System.out.println("ФИО - " + worker.getFullName() + ", ЗП - " + worker.getSalary());
            }
        }
    }

    //Метод поиска сотрудников с ЗП меньше заданного числа
    public static void printWorkersMinSalary(Employee[] workers, int number) {
        System.out.println("Список сотрудников с ЗП ниже " + number);
        for (Employee worker : workers) {
            if (worker != null && worker.getSalary() < number) {
                System.out.println("ФИО - " + worker.getFullName() + ", ЗП - " + worker.getSalary() +
                        ", ID - " + worker.getId());
            }
        }
    }

    //Метод поиска сотрудников с ЗП больше заданного числа
    public static void printWorkersMaxSalary(Employee[] workers, int number) {
        System.out.println("Список сотрудников с ЗП выше " + number);
        for (Employee worker : workers) {
            if (worker != null && worker.getSalary() >= number) {
                System.out.println("ФИО - " + worker.getFullName() + ", ЗП - " + worker.getSalary() +
                        ", ID - " + worker.getId());
            }
        }
    }
}

