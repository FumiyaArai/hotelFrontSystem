import java.util.ArrayList;
import java.util.InputMismatchException;
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

    	// ホテル受付システムの処理が終了しないように無限ループさせる
        while (true)
        {
        	// 部屋一覧展開用
        	String connectRoomNumber = "";

        	// 部屋番号の連結
        	for (Room menuRoom : roomList)
        	{
        		connectRoomNumber = connectRoomNumber + menuRoom.roomNumber + "号室\r\n";
        	}

            // 挨拶 + 部屋一覧展開
            System.out.println("ようこそ Rushout ホテルへ！\r\n\r\n～当ホテル部屋一覧～\r\n" + connectRoomNumber + "\r\n次のメニューから番号を入力して下さい。\r\n\r\n1）部屋予約\r\n2）予約確認\r\n3）チェックイン\r\n4）チェックアウト\r\n0）システムシャットダウン(全ての情報が削除されます)");

            // メニュー選択
            int menuNumber = 999;

            // 入力_インスタンス化
            Scanner scan = new Scanner(System.in);

            // メニュー選択_分岐
            try
            {
                System.out.print("メニュー番号(半角)：");
                menuNumber = scan.nextInt();

                // 部屋予約メニュー
                switch (menuNumber)
                {
                    case 1:
                    System.out.println("\r\n部屋予約をします。");
                    reserve();
                    break;

                    case 2:
                    System.out.println("\r\n予約確認をします。");
                    reserveCheck();
                    break;

                    case 3:
                    System.out.println("\r\nチェックインをします。");
                    checkIn();
                    break;

                    case 4:
                    System.out.println("\r\nチェックアウトをします。");
                    checkOut();
                    break;

                    case 0:
                    System.out.println("\r\nホテル予約システムを終了します。");
                    break;

                    default:
                    System.out.println("\r\nメニューに無い番号が選択されました。");
                    break;
                }
            }
            catch (InputMismatchException e)
            {
                // エラー分
                System.out.println("\r\n異常なメニュー番号が入力されました。");
            }

            // システムシャットダウン
            if (menuNumber == 0)
            {
                break;
            }

            // 再度メニュー画面を表示することを通知する
            System.out.println("メニュー選択に戻ります。\r\n\r\n");
        }
    }


    // 部屋予約メソッド
    public static void reserve()
    {
        // ホテル選択
        int reserveHotelNumber = 0;

        // 部屋検索フラグ
        boolean reserveRoomSearchFlag = false;

        // 入力_インスタンス化
        Scanner scan = new Scanner(System.in);

        try
        {
            // 部屋番号入力
            System.out.print("部屋番号(半角)：");
            reserveHotelNumber = scan.nextInt();

            // 部屋が存在するか調べる
            for (Room reserveSearchRoom : roomList)
            {
            	// 入力した部屋番号と一致する部屋番号があるか調べる
            	if (reserveHotelNumber == reserveSearchRoom.roomNumber)
            	{
            		// 入力された部屋番号が見つかったので部屋検索フラグをtrueにする
                    reserveRoomSearchFlag = true;

            		// ステータスが未予約か調べる
            		if (reserveSearchRoom.roomStatus == "未予約")
            		{
            			// ステータスを予約済にする
                		reserveSearchRoom.roomStatus = "予約済";

                        // ステータス変更したことを通知する
                        System.out.println("部屋番号" + reserveHotelNumber + "号室が　予約　されました。\r\n");

                        // 繰り返しを抜ける
                		break;
            		}
            		// 未予約でない部屋は予約しない
            		else
            		{
            			// 予約できないことを通知する
                        System.out.println("部屋番号" + reserveHotelNumber + "号室は空いておりませんので、ご予約いただけません。\r\n");

                        // 繰り返しを抜ける
                		break;
            		}
            	}
            }

            // 入力された部屋番号が見つからなかった場合
            if (reserveRoomSearchFlag == false)
            {
                System.out.println("入力された部屋はありません。\r\n");
            }
        }
        catch (InputMismatchException e)
        {
            // エラー分
            System.out.println("異常な部屋番号が入力されました。\r\n");
        }
    }


    // 予約確認メソッド
    public static void reserveCheck()
    {
    	// ホテル選択
        int reserveCheckHotelNumber = 0;

        // 部屋検索フラグ
        boolean reserveCheckRoomSearchFlag = false;

    	// 入力_インスタンス化
        Scanner scan = new Scanner(System.in);

        try
        {
        	// 部屋番号入力
            System.out.print("部屋番号(半角)：");
            reserveCheckHotelNumber = scan.nextInt();

            // 部屋が存在するか調べる
            for (Room reserveCheckSearchRoom : roomList)
            {
            	// 入力した部屋番号と一致する部屋番号があるか調べる
            	if (reserveCheckHotelNumber == reserveCheckSearchRoom.roomNumber)
            	{
            		// 入力された部屋番号が見つかったので部屋検索フラグをtrueにする
            		reserveCheckRoomSearchFlag = true;

            		// ステータスを通知する
            		System.out.println("部屋番号" + reserveCheckHotelNumber + "号室は　" + reserveCheckSearchRoom.roomStatus + "　です\r\n");

            		// 繰り返しを抜ける
                	break;
            	}
            }

            // 入力された部屋番号が見つからなかった場合
            if (reserveCheckRoomSearchFlag == false)
            {
                System.out.println("入力された部屋はありません。\r\n");
            }
        }
        catch (InputMismatchException e)
        {
            // エラー分
            System.out.println("異常な部屋番号が入力されました。\r\n");
        }
    }


    // チェックインメソッド
    public static void checkIn()
    {
        // ホテル選択
        int checkInHotelNumber = 0;

        // 部屋検索フラグ
        boolean checkInRoomSearchFlag = false;

        // 入力_インスタンス化
        Scanner scan = new Scanner(System.in);

        try
        {
            // 部屋番号入力
            System.out.print("部屋番号(半角)：");
            checkInHotelNumber = scan.nextInt();

            // 部屋が存在するか調べる
            for (Room checkInSearchRoom : roomList)
            {
            	// 入力した部屋番号と一致する部屋番号があるか調べる
            	if (checkInHotelNumber == checkInSearchRoom.roomNumber)
            	{
            		// 入力された部屋番号が見つかったので部屋検索フラグをtrueにする
            		checkInRoomSearchFlag = true;

            		// ステータスが予約済であるか調べる
            		if (checkInSearchRoom.roomStatus == "予約済")
            		{
            			// ステータスをチェックインにする
            			checkInSearchRoom.roomStatus = "チェックイン";

            			// チェックインしたこと通知する
            			System.out.println("部屋番号" + checkInHotelNumber + "号室に　チェックイン　しました。\r\n");

            			// 繰り返しを抜ける
                		break;
            		}
            		// 予約済でない部屋のチェックインはしない
            		else
            		{
            			// チェックインできないことを通知する
                        System.out.println("部屋番号" + checkInHotelNumber + "号室はご予約されていないため、チェックインできません。\r\n");

                        // 繰り返しを抜ける
                		break;
            		}
            	}
            }

            // 入力された部屋番号が見つからなかった場合
            if (checkInRoomSearchFlag == false)
            {
                System.out.println("入力された部屋はありません。\r\n");
            }
        }
        catch (InputMismatchException e)
        {
            // エラー分
            System.out.println("異常な部屋番号が入力されました。\r\n");
        }
    }


    // チェックアウトメソッド
    public static void checkOut()
    {
    	// ホテル選択
        int checkOutHotelNumber = 0;

        // 部屋検索フラグ
        boolean checkOutRoomSearchFlag = false;

        // 入力_インスタンス化
        Scanner scan = new Scanner(System.in);

        try
        {
            // 部屋番号入力
            System.out.print("部屋番号(半角)：");
            checkOutHotelNumber = scan.nextInt();

            // 部屋が存在するか調べる
            for (Room checkOutSearchRoom : roomList)
            {
            	// 入力した部屋番号と一致する部屋番号があるか調べる
            	if (checkOutHotelNumber == checkOutSearchRoom.roomNumber)
            	{
            		// 入力された部屋番号が見つかったので部屋検索フラグをtrueにする
            		checkOutRoomSearchFlag = true;

            		// ステータスがチェックインであるか調べる
            		if (checkOutSearchRoom.roomStatus == "チェックイン")
            		{
            			// ステータスを未予約（チェックアウト）にする
            			checkOutSearchRoom.roomStatus = "未予約";

            			// チェックアウトしたことを通知する
            			System.out.println("部屋番号" + checkOutHotelNumber + "号室に　チェックアウト　しました。\r\n");

            			// 繰り返しを抜ける
                		break;
            		}
            		// チェックインされていない部屋のチェックアウトはしない
            		else
            		{
            			// チェックアウトできないことを通知する
                        System.out.println("部屋番号" + checkOutHotelNumber + "号室はチェックインされていないため、チェックアウトできません。\r\n");

                        // 繰り返しを抜ける
                		break;
            		}
            	}
            }

            // 入力された部屋番号が見つからなかった場合
            if (checkOutRoomSearchFlag == false)
            {
                System.out.println("入力された部屋はありません。\r\n");
            }
        }
        catch (InputMismatchException e)
        {
            // エラー分
            System.out.println("異常な部屋番号が入力されました。\r\n");
        }
    }
}