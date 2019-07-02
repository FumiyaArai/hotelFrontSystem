import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HotelFront
{
	// クラスの配列
	public static List<Room> roomList = new ArrayList<>();

    public static void main(String args[])
    {
    	// リストに部屋を作る
    	roomList.add(0, new Room(101, "未予約"));
    	roomList.add(1, new Room(102, "未予約"));
    	roomList.add(2, new Room(103, "未予約"));

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
                System.out.println("部屋予約をします。\r\n");
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
        int reserveHotelNumber = 0;

        // 入力_インスタンス化
        Scanner scan = new Scanner(System.in);

        try
        {
            // 部屋番号入力
            System.out.print("部屋番号(半角)：");
            reserveHotelNumber = scan.nextInt();

            // 部屋が存在するか調べる
            for(Room searchRoom : roomList)
            {
            	// 入力した部屋番号と一致する部屋番号があるか調べる
            	if(reserveHotelNumber == searchRoom.roomNumber)
            	{
            		// 既に予約されていないか調べる
            		if(searchRoom.roomStatus == "予約済")
            		{
            			System.out.println("部屋番号" + reserveHotelNumber + "は既に予約済です。\r\nメニュー選択に戻ります。\r\n\r\n");
            			// 繰り返しを抜ける
                		break;
            		}

            		// Roomクラスを呼び出してステータスを変更する
                    searchRoom.roomStatus = "予約済";

                    // ステータス変更したことを通知する
                    System.out.println("部屋番号" + reserveHotelNumber + "号室が予約されました。\r\nメニュー選択に戻ります。\r\n\r\n");

                    // 繰り返しを抜ける
            		break;
            	}
            }
        }
        catch (Exception e)
        {
            // エラー分
            System.out.println("入力された部屋はありません。\r\n最初からやり直して下さい。");
        }
    }

    // 予約確認メソッド
    public static void reserveCheck()
    {
    	// ホテル選択
        int reserveCheckHotelNumber = 0;

    	// 入力_インスタンス化
        Scanner scan = new Scanner(System.in);

        try
        {
        	// 部屋番号入力
            System.out.print("部屋番号(半角)：");
            reserveCheckHotelNumber = scan.nextInt();
        }
        catch (Exception e)
        {
            // エラー分
            System.out.println("入力された部屋はありません。\r\n最初からやり直して下さい。");
        }
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