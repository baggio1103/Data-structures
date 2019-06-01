public class BloomFilter
{
    public int filter_len;
    byte [] bits;
    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        bits = new byte[filter_len];
    }

    // хэш-функции
    public int hash1(String str1)
    {
        // 17
        int code = 0;
        for(int i = 0; i < str1.length(); i++)
        {
             code += (17)*(int)str1.charAt(i);

        }
        // реализация ...
        code %= filter_len;
        return code;
    }
    public int hash2(String str1)
    {
        // 223
        // реализация ...
       int code = 0;
       for (int i = 0; i < str1.length(); i++){
           code += (223)*(int)str1.charAt(i);
       }
        code %= filter_len;
        return code;
    }

    public void add(String str1)
    {
        // добавляем строку str1 в фильтр
        bits[hash1(str1)] = 1;
        bits[hash2(str1)] = 1;
    }

    public boolean isValue(String str1)
    {
        // проверка, имеется ли строка str1 в фильтре
        if (bits[hash1(str1)] == 1) {
            return true;
        }
        else if (bits[hash2(str1)] == 1){
            return true;
        }
        else
            return false;
    }
}
