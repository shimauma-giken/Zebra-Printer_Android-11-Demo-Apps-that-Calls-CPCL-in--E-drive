### プリンタ側の準備

1. CPCLスクリプト作成する。

<<<<<<< HEAD
        ファイル名の例
        AAAVS01.PRN
=======
        例、demo02.PRN
>>>>>>> 476cf543a202b05cc0adfd4e7d656314993e24e5

1. 上記ファイルをプリンタの内蔵ドライブに保存する。

1. UFコマンドでファイルが正常に出力されるか念のために確認する。

        ! UF demo02.PRN [Enter]


### Android側の準備

1. Androidのソースコードをダウンロードする。
        ※ソースコードはA11向けに作成されている。A12以上の場合はAndroid OSに併せてソースコードを改変する事。

1. MainActivityの変数を変更する。(23-24行)

        ```java
        // デモファイル名
        String cpclFile = "demo02.prn";
        // Bluetooth ClassicのMACアドレス
        String bluetoothMac = "04:7F:0E:7E:EE:9D";
        ```

1. Appをビルドし、Android端末にインストールする。


### デモ方法

1. アプリを起動し、Printボタンを押下することでラベルを印刷される。


