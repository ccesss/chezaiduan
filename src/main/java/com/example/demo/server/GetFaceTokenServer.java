package com.example.demo.server;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

@Service
public class GetFaceTokenServer {



        public int faceppDetect(){

            //File file = new File("/faceppDemo/src/com/company/photo.jpeg");
            File file = new File("C:/Users/HC/Documents/人脸识别2.jpg");
            byte[] buff = getBytesFromFile(file);
            String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
            HashMap<String, String> map = new HashMap<>();
            HashMap<String, byte[]> byteMap = new HashMap<>();
//学长的
//        map.put("api_key", "ymiNQphADmIHWo3FCzt3wUhHtUjjw_XN");
//        map.put("api_secret", "vU6SblaJr_xOKDS9l9CxfTqDJgN9LUOr");
//我的
            map.put("api_key", "80MiCeoetMcbXVQOW-J3amUhdZmUpkG1");
            map.put("api_secret", "HBb9bCXNdoMsGNXuXLsPeElYN9wlzbel");

            //map.put("face_token1", face_token);
            //map.put("image_base64", imgBase64);
            byteMap.put("image_file", buff);


            try{
                byte[] bacd = post(url, map, byteMap);
                String str = new String(bacd);
                System.out.println(str);


                JSONObject jsonObject = JSONObject.fromObject(str);




            }catch (Exception e) {
                e.printStackTrace();
            }


            return 1;

        }

        private final static int CONNECT_TIME_OUT = 30000;
        private final static int READ_OUT_TIME = 50000;
        private static String boundaryString = getBoundary();
        protected static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
            HttpURLConnection conne;
            URL url1 = new URL(url);
            conne = (HttpURLConnection) url1.openConnection();
            conne.setDoOutput(true);
            conne.setUseCaches(false);
            conne.setRequestMethod("POST");
            conne.setConnectTimeout(CONNECT_TIME_OUT);
            conne.setReadTimeout(READ_OUT_TIME);
            conne.setRequestProperty("accept", "*/*");
            conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
            conne.setRequestProperty("connection", "Keep-Alive");
            conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
            DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
            Iterator iter = map.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<String, String> entry = (Map.Entry) iter.next();
                String key = entry.getKey();
                String value = entry.getValue();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                        + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.writeBytes(value + "\r\n");
            }

            obos.writeBytes("--" + boundaryString + "--" + "\r\n");
            obos.writeBytes("\r\n");
            obos.flush();
            obos.close();
            InputStream ins = null;
            int code = conne.getResponseCode();
            try{
                if(code == 200){
                    ins = conne.getInputStream();
                }else{
                    ins = conne.getErrorStream();
                }
            }catch (SSLException e){
                e.printStackTrace();
                return new byte[0];
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buff = new byte[4096];
            int len;
            while((len = ins.read(buff)) != -1){
                baos.write(buff, 0, len);
            }
            byte[] bytes = baos.toByteArray();
            ins.close();
            return bytes;
        }
        private static String getBoundary() {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for(int i = 0; i < 32; ++i) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
            }
            return sb.toString();
        }
        private static String encode(String value) throws Exception{
            return URLEncoder.encode(value, "UTF-8");
        }

        public static byte[] getBytesFromFile(File f) {
            if (f == null) {
                return null;
            }
            try {
                FileInputStream stream = new FileInputStream(f);
                ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
                byte[] b = new byte[1000];
                int n;
                while ((n = stream.read(b)) != -1)
                    out.write(b, 0, n);
                stream.close();
                out.close();
                return out.toByteArray();
            } catch (IOException e) {
            }
            return null;
        }

}
