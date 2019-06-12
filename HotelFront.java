import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

class HotelFront
{
    // ホテル予約状態_配列
    Map<Integer, Room> hotel = new HashMap<>();

    // クラスのオブジェクトを生成
    Room room101 = new Room(101, "");
    Room room102 = new Room(102, "");
    Room room103 = new Room(103, "");

    // Mapにキーと値を格納
    //hotel.put(101, null);
    //hotel.put(102, null);
    //hotel.put(103, null);

    public static void main(String args[])
    {
        while(true)
        {
            // 挨拶
            System.out.println("ようこそ Rushout ホテルへ！\r\nやりたいことを次の番号から選んで下さい。\r\n\r\n1）部屋予約\r\n2）予約確認\r\n3）チェックイン\r\n4）チェックアウト\r\n0）システムシャットダウン(全ての情報が削除されます)");
        
            // メニュー選択
            int menuNumber = 0;

            // 入力_インスタンス化
            Scanner scan = new Scanner(System.in);

            // メニュー選択_分岐
            try
            {
                System.out.print("入力：");
                menuNumber = scan.nextInt();
            }
            catch (Exception e)
            {
                // エラー分
                System.out.println("数値を入力して下さい。\r\n最初からやり直して下さい。");
            }

            // 部屋予約メニュー
            switch(menuNumber)
            {
                case 1:
                System.out.println("部屋予約をします。");
                reserve();
                break;

                case 2:
                System.out.println("予約確認をします。");
                reserveCheck();
                break;

                case 3:
                System.out.println("チェックインをします。");
                checkIn();
                break;

                case 4:
                System.out.println("チェックアウトをします。");
                checkOut();
                break;

                case 0:
                System.out.println("ホテル予約システムを終了します。");
                break;

                default:
                System.out.println("メニューに無い番号が選択されました。\r\n最初からやり直して下さい。");
                break;
            }

            // システムシャットダウン
            if(menuNumber == 0)
            {
                break;
            }
        }
    }


    // 部屋予約メソッド
    public static void reserve()
    {
        // ホテル選択
        int hotelNumber = 0;
        Room reserveRoom = null;

        // 部屋予約メニュー
        while(true)
        {
            // 入力_インスタンス化
            Scanner scan = new Scanner(System.in);

            try
            {
                // 部屋番号入力
                System.out.print("部屋番号(半角)：");
                hotelNumber = scan.nextInt();
                
                // Roomクラスを呼び出してステータスを変更する
                reserveRoom = HotelFront.hotel.get(hotelNumber);
                reserveRoom.roomStatus = "予約中";
            }
            catch (Exception e)
            {
                // エラー分
                System.out.println("入力された部屋はありません。\r\n最初からやり直して下さい。");
            }

            // 繰り返しを抜ける
            break;
        }
    }

    // 予約確認メソッド
    public static void reserveCheck()
    {
        System.out.println("い");
    }
    
    // チェックインメソッド
    public static void checkIn()
    {
        System.out.println("う");
    }

    // チェックアウトメソッド
    public static void checkOut()
    {
        System.out.println("え");
    }
}