public class Main {
    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook();

        book.addWorker ("Прохорова М.В.", 2, 55_000);
        book.addWorker("Петров Н.И.", 2, 35_000);
        book.addWorker("Екимов А.П.", 1, 80_000);
        book.addWorker("Пономаренко А.А.", 3, 40_000);
        book.addWorker("Прохорова М.В.", 5, 65_300);
        book.addWorker("Беленкова В.С.", 4, 35_700);
        book.addWorker("Лапоногова О.Р.", 4, 60_000);
        book.addWorker("Дорохова Т.Ю.", 1, 65_300);
        book.addWorker("Попов А.А.", 1, 70_500);
        book.addWorker("Иванов В.П.", 3, 45_000);

        System.out.println();
        System.out.println("Список сотрудников компании");
        book.printWorkers();

        System.out.println();
        int sumSalary = book.calculateSumSalary();
        System.out.println("Сумма затрат на ЗП в месяц - " + sumSalary);

        Employee minSalaryWorker = book.minSalary();
        System.out.println("Минимальная зарплата: " + minSalaryWorker);

        Employee maxSalaryWorker = book.maxSalary();
        System.out.println("Максимальная зарплата: " + maxSalaryWorker);

        double averageSalaryWorker = book.averageSalary();
        System.out.println("Среднее значение зарплат в компании - " + averageSalaryWorker);

        System.out.println();
        book.printFullNameWorker();

        System.out.println();
        System.out.println("Список сотрудников после индексации зарплаты");
        book.indexationSalary(10);
        book.printWorkers();

        System.out.println();
        minSalaryWorker = book.minSalary(1);
        System.out.println("Минимальная зарплата в отделе - " + minSalaryWorker);

        maxSalaryWorker = book.maxSalary(1);
        System.out.println("Максимальная зарплата в отделе - " + maxSalaryWorker);

        int sumSalaryInDepartment = book.calculateSumSalary(4);
        System.out.println("Сумма затрат на ЗП в месяц на отдел - " + sumSalaryInDepartment);

        double averageSalaryWorkerInDepartment = book.averageSalary(1);
        System.out.println("Среднее значение зарплат в отделе - " + averageSalaryWorkerInDepartment);

        System.out.println();
        book.indexationSalary(5, 3);
        book.printWorkersInDepartment(5);

        System.out.println();
        int parameter = 55_700;
        book.printWorkersMinSalary(parameter);

        System.out.println();
        parameter = 60_000;
        book.printWorkersMaxSalary(parameter);

        System.out.println();
        book.deleteWorker(4);
        System.out.println("Список сотрудников после увольнения:");
        book.printWorkers(); // распечатаем список сотрудников после удаления

        System.out.println();
        book.addWorker("Прохоров В.А.", 1, 44_000);
        System.out.println("Список сотрудников после добавления:");
        book.printWorkers(); // распечатаем список сотрудников после добавления нового

        System.out.println();
        int id=11;
        Employee workerID = book.findWorkerID(id);
        if (workerID != null) {
            System.out.println("Сотрудник, найденный по ID: " + workerID);
        } else System.out.println("Сотрудника с таким ID нет!");
    }
}

