#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
/*Процесс 1 открывает файл и порождает потомка 2, после этого пишет в файл N байт и посылает сигнал процессу 2. Процесс 2 пишет N байт в файл, посылает сигнал процессу 1 и завершается. Процесс 1, получив сигнал, считывает данные из файла, выводит их на экран и завершается.*/
FILE *TEXT_FILE;

void signal1()
{
    char ch;
    while ((ch = fgetc(TEXT_FILE)) != EOF)
        printf("%c", ch);
}

void signal2()
{
    for (int i = 0; i < 80; i++)
    {
        fprintf(TEXT_FILE, "f");
        fflush(TEXT_FILE);
    }
}

int main()
{
    TEXT_FILE = fopen("TEXT_FILE.txt", "r+");
    pid_t pid = fork(); //развилка
    switch (pid)
    {
    case -1:
        printf("Go home");
        break;
    case 0: //потомок
        signal(SIGUSR2, signal2);
        pause();
        kill(getppid(), SIGUSR1);
        kill(pid, SIGTERM);
        break;
    default: //родитель
        signal(SIGUSR1, signal1);
        for (int i = 0; i < 80; i++)
        {
            fprintf(TEXT_FILE, "i");
            fflush(TEXT_FILE);
        }
        kill(pid, SIGUSR2);
        pause();
        break;
    }
    kill(getpid(), SIGTERM);
    return 0;
}
