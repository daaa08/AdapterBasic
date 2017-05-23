#### Log

로그캣 : 앱의 실행 흐름을 보는데 도움
- 로그는 항상 에러가난 것 위쪽에 작성
- Log.v : 프로그램 진행 흐름
- Log.d : 디버그
- Log.i : 정보 전달
- Log.w : 경고성 이슈
- Log.e :  오류 표시
=> Log.v("tsg","msg");

#### 디버그
- 키스토어 바이너리 관계 없이 로그 출력
- 개발시 BuildConfig.DEBUG : true
- 디버그 모드일경우의 apk는 스토어에 올리기 불가능

#### 릴리즈
- 키스토어 바이너리 관계 없이 로그 미출력
- 배포시 BuildConfig.DEBUG : false

#### spinner
- 객체를 선택할 수 있는 상자를 화면에 출력하고 클릭하면 목록이 나오는 형태
- 목록을 나타나게 하려면 adapter라는 객체 사용

#### inflate
- xml을 class로 바꿔 자바에서 사용할 수 있도록 객체로 만들어 줌
(xml은 디자인일뿐이라서 프로그램에 적용하려면 메모리에 올려야 함)

#### Listview

- 내가 보여주고자하는 데이터가 많아질 경우 스크롤도 힘들어짐..
-> 때문에 getView() 메소드 사용. 정확히는 getView()의 convertView.
- 리스트뷰를 그리기위해서는 adapter를 사용해야 함
- getView()의 convertView를 사용하게되면 이전에 그렸던 뷰를 다시한번 넘김
