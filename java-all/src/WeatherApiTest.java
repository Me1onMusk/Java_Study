
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApiTest {
    public static void main(String[] args) {

        String apiKey = "d1cdb2c21c83c491fcf59cbd39de56cf";
        String city = "seoul";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        try {

            // 1.URL 객체 생성
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 2.요청 메서드 설정 (GET)
            conn.setRequestMethod("GET");

            // 3.응답 코드 확인
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 4.Jackson 파싱


            } else {
                System.out.println("API 호출 실패, 응답 코드 : " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
