"hello" == "hello";//true

"hello1" == "hello" + "1";//true

"hello1" == "hello" + new String("1");//false，地址不一样

"hello" == new String("hello");//false，地址不一样

128 == 128;//true
128 == new Integer(128);//true
129 == 129;//true
129 == new Integer(129);//false




