### プリンタ側の準備

1. CPCLスクリプト作成する。

        例、demo02.PRN

1. 上記ファイルをプリンタの内蔵ドライブに保存する。

1. UFコマンドでファイルが正常に出力されるか念のために確認する。

        ! UF demo02.PRN [Enter]


### Android側の準備

1. MainActivityの下記行を修正する。

        String theBtMacAddress = "04:7F:0E:7E:EE:9D";
                                  ^^^^^^^^^^^^^^^^^^
        接続先プリンタのBLuetooth Mac Addressにする。

1. Appをビルドし、Android端末にインストールする。


### デモ方法

1. アプリを起動し、Printボタンを押下することでラベルを印刷する。


