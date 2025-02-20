### プリンタ側の準備

1. CPCLを下記ファイル名で作成する。

        AAAVS01.PRN

1. 上記ファイルをプリンタのEドライブに保存する。

1. 下記コマンドでファイルが正常に出力されるか念のために確認する。

        ! UF AAAVS01.PRN [Enter]


### Android側の準備

1. MainActivityの下記行を修正する。

        String theBtMacAddress = "04:7F:0E:7E:EE:9D";
                                  ^^^^^^^^^^^^^^^^^^
        接続先プリンタのBLuetooth Mac Addressにする。

1. Appをビルドし、Android端末にインストールする。


### デモ方法

1. アプリを起動し、Printボタンを押下することでラベルを印刷する。


