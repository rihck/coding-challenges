package main.leetcode;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;

class Convert
{
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_pages;
    List<Device> data;
}
class OperatingParams
{
    Integer rotorSpeed;
    Float slack;
    Float rootThreshold;
}
class Device
{
    Integer id;
    Long timestamp;
    String status;
    OperatingParams operatingParams;
    Object asset;
    Object parent;
}
class Result
{
    /*
    * Complete the 'numDevices' function below.
    *
    * The function is expected to return an INTEGER.
    * The function accepts following parameters:
    * 1. STRING statusQuery
    * 2. INTEGER threshold
    * 3. STRING dateStr
    * https://jsonmock.hackerrank.com/api/iot_devices/search?status=
    <statusQuery>&page=<pageNumber>
    * Full Question: https://drive.google.com/drive/u/0/folders/1SpQL0jfXuOnhZdC72qO4kZYnH1W1-GLG
    */
    public static int numDevices(String statusQuery, int threshold, String
            dateStr)
    {
        try
        {
            int initial_page = 1;
            int total_pages = 3;
            String output="", res="";
            BufferedReader br = null;
            Gson gson = new Gson();
            Convert cc;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date parsedDate = dateFormat.parse("01-"+dateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(parsedDate);

            cal.add(Calendar.MONTH, 1);
            Date parsedDate2 = cal.getTime();
            List<Device> list = new LinkedList<>();

            URL url1 = new URL("https://jsonmock.hackerrank.com/api/iot_devices/search? status="+statusQuery+"&page=1");
            HttpsURLConnection https1 = (HttpsURLConnection) url1.openConnection();

            https1.setRequestMethod("GET");
            if(https1.getResponseCode() ==200)
            {
                br = new BufferedReader(new
                        InputStreamReader((https1.getInputStream())));
                while ((output = br.readLine()) != null)
                    res += output;

                System.out.println(res);
                cc = gson.fromJson(res,Convert.class);
                list.addAll(cc.data);
            }
            res = "";
            output="";
            https1.disconnect();
            URL url2 = new URL("https://jsonmock.hackerrank.com/api/iot_devices/search? status="+statusQuery+"&page=2");
            HttpsURLConnection https2 = (HttpsURLConnection) url2.openConnection();
            https2.setRequestMethod("GET");
            if(https2.getResponseCode() ==200)
            {
                br = new BufferedReader(new
                        InputStreamReader((https2.getInputStream())));
                while ((output = br.readLine()) != null)
                    res += output;
                System.out.println(res);
                cc = gson.fromJson(res,Convert.class);
                list.addAll(cc.data);
            }
            res = "";
            output="";
            https2.disconnect();

            URL url3 = new URL("https://jsonmock.hackerrank.com/api/iot_devices/search? status="+statusQuery+"&page=3");
            HttpsURLConnection https3 = (HttpsURLConnection) url3.openConnection();
            https3.setRequestMethod("GET");
            if(https3.getResponseCode() ==200)
            {
                br = new BufferedReader(new
                        InputStreamReader((https3.getInputStream())));
                while ((output = br.readLine()) != null)
                    res += output;

                System.out.println(res);
                cc = gson.fromJson(res,Convert.class);
                list.addAll(cc.data);
            }
            res = "";
            output="";
            https3.disconnect();
            System.out.println(parsedDate.getTime());
            List<Device> flist = list.stream().filter(p ->
                    p.operatingParams.rootThreshold>threshold &&
                            p.timestamp>=parsedDate.getTime() && p.timestamp <
                            parsedDate2.getTime()).collect(Collectors.toList());
            return flist.size();
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

        return -1;
    }
}
public class NumDevices {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new
                InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new
                FileWriter(System.getenv("OUTPUT_PATH")));
        String statusQuery = bufferedReader.readLine();
        int threshold = Integer.parseInt(bufferedReader.readLine().trim());
        String dateStr = bufferedReader.readLine();
        int result = Result.numDevices(statusQuery, threshold, dateStr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}