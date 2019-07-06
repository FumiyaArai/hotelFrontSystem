public class Room
{
    // 部屋番号
    int roomNumber;
    // 部屋の予約状態（ステータス）
    String roomStatus;

    // コンストラクタ
   Room(int roomNumber, String roomStatus)
    {
        // 初期化
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
    }
}