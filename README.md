# E-learning APP Report (Assignment 2~5)

### 小组成员：17301127 李朴 17301083 张文豪

## 一、报告概述

本报告涵盖我小组二人本学期安卓课程中布置的Assignment 2～5的详细设计思路及实现方式。



## 二、需求实现情况一览

在实现几次Assignment的过程中，我们按部就班，步步为营，详细记录了各项Assignment实现的情况，现展示如下：

+ **Assignment2**

  |                           需求描述                           |                           实现情况                           | 实现日期 |
  | :----------------------------------------------------------: | :----------------------------------------------------------: | -------- |
  |                         查看课程列表                         |      ***成功实现***。我们使用RecycleView展示课程列表。       | 12.25    |
  | 导航查看详细课程简介，包括课程信息、教学大纲、课程日历，并可以进行课程注册 | ***成功实现***。点击课程列表中的一门课程后，可以展示所有需求中规定的课程的详细信息，并有相应按钮提供课程注册功能。 | 12.26    |
  |                  通过登录进入E-learning平台                  | ***成功实现***。我们在老师提供的服务器的数据库中额外增加用户表，储存账号与密码信息，登录时进行检测。 | 12.25    |
  |                   浏览、搜索多媒体学习材料                   | ***成功实现***。我们为搜索学习材料专门设定了一个页面，可以通过关键词匹配搜索多媒体学习材料，包括视频、音频、PDF、图片等。我们同样使用RecycleView展示搜索得到的学习材料列表。 | 12.27    |
  |                  登录时账号密码的有效性检验                  | ***成功实现***。上面提到我们已经建立用户表，用户登录时我们会将其输入与数据库中数据进行匹配，检验其有效性。 | 12.25    |
  |                  使用RecycleView展示数据集                   | ***成功实现***。上面已经提到，我们的课程列表展示及搜索得到的学习材料列表展示皆使用RecycleView展示。 | 12.27    |
  |          从Web服务器上获取课程信息、学习材料等数据           | ***成功实现***。我们使用API从服务器获取图片、视频、音频、PDF、文字等数据，传输到前端展示。 | 12.27    |
  |           对于视频、音频课程，需要提供课程广播功能           |                       ***成功实现***。                       | 12.28    |

  功能实现程度：***100%***

  

+ **Assignment3**

  |                           需求描述                           |                           实现情况                           | 实现日期 |
  | :----------------------------------------------------------: | :----------------------------------------------------------: | -------- |
  | 尽量丰富课程列表的设计，在RecycleView的基础上添加视频、统计信息等其他吸引眼球的东西 | ***成功实现。***我们在使用RecycleView的基础上，着力丰富列表设计。您可以在列表中看到课程名称、课程视频封面图、课程提供学校、课程注册人数、“国家精品”标签等一系列信息，较为全面。 | 12.27    |
  |                    导航切换时提供转场动画                    |   ***成功实现。***我们在每一处导航切换处都设置了转场动画。   | 12.28    |
  | 用户只需登录一次，在未退出的情况下，下次登录时不需要进行登录操作 | ***成功实现。***主要使用SharePreferences在登录时进行判断实现。 | 12.31    |
  |    用户浏览数据时，将其存入本地缓存，只需从服务器获取一次    | ***成功实现。***用户获取图片、视频、音频、PDF等数据时，我们都会将其存入本地缓存，确保下次访问数据时直接从本地获取。 | 1.1      |
  | 对于运行时间比较长的任务，比如下载图片或视频时，需要异步或多线程操作，并且需将其存入缓存 | ***成功实现。***在获取图片、视频、音频、PDF等数据时，我们都会使用多线程来提高传输速度，另外，上面已经提到过，我们会将其存入缓存，确保下次访问时直接从本地获取。 | 1.3      |
  | 使用broadcast receiver和notification来通知用户服务器端的更新 |                       ***成功实现。***                       | 1.2      |

  功能实现程度：***100%***



+ **Assignment4**

  |                  需求描述                  |                           实现情况                           | 实现日期 |
  | :----------------------------------------: | :----------------------------------------------------------: | :------: |
  | 使用mvvm及room重写部分程序，推荐使用Kotlin | ***成功实现。***我们在mvvm框架下，使用Kotlin语言，并使用room接口连接服务器，重写了“教师详情”模块。 |   1.5    |
  |           在app中加入滑动引导页            | ***成功实现。***我们设置用户初次登录时会展示可滑动引导页，第二次登录时即可跳过引导页，直接进入主界面。 |   1.4    |
  |           实现微信/QQ第三方登录            |          ***成功实现。***我们成功实现QQ第三方登录。          |   1.4    |
  |           分享课程信息至微信/SMS           |      ***成功实现。***我们成功实现将课程信息分享至微信。      |   1.4    |

  功能实现程度：***100%***



+ **Assignment5**

  |            需求描述            |                           实现情况                           | 实现日期 |
  | :----------------------------: | :----------------------------------------------------------: | :------: |
  | 实现至少一个活动模块的安卓测试 | ***成功实现。***我们使用junit 4.12单元测试框架，对程序onCreate()方法进行了自动测试（实际上测试了整个程序的加载过程）。 |   1.5    |

  功能实现程度：***100%***

  

整体来说，我们成功实现了各个文档中要求的所有功能需求或任务需求。另外，在某些模块，我们根据自己对E-learning平台的理解，增添了部分自己的设计，这些设计您可以在后面的详细设计说明中看到。



## 三、详细设计说明

PS: 该部分以功能设计介绍为主，部分任务需求的实现说明请看`四、部分需求实现说明`。

### 3.1 引导页



### 3.2 登录界面

<img src="/Users/pc/Desktop/E-learning截图/5.png" alt="5" style="zoom:67%;" />

+ 我们的登录界面实现了第三方登录，图中展示了微信、QQ、微博的登录选择，但实际上我们只实现了QQ第三方登录的功能。

<img src="/Users/pc/Desktop/E-learning截图/6.png" alt="6" style="zoom:67%;" />

+ 输入密码时，如果密码输入格式不符合要求（不到5个字符），会有警告提示，并且无法点击登录按钮。
+ 当密码符合要求时，点击登录按钮，我们将会拿用户输入数据与数据库中的数据进行匹配，如果成功匹配，则跳转至***主页***，如果无法成功匹配，则登录失败。

### 3.3 主页

<img src="/Users/pc/Desktop/E-learning截图/1.png" alt="1" style="zoom: 67%;" />

+ 主页主要由两部分构成：
  + 上方可滑动精品课程推荐栏。点击后查看推荐课程的详细信息。
  + 下方“王牌教师”推荐栏。推荐栏中会显示教师的姓名、邮箱、授课描述等信息。
+ 屏幕下方有导航跳转栏，当前页面在Home页面，点击其他标志会跳转至相应页面，后面界面同理，不再赘述。
+ “王牌教师”推荐栏使用`RecycleView`展示，下面是其复用的模版：
+ 点击“王牌教师”推荐栏中的某一位老师栏，会跳转至***教师详情界面***。

### 3.4 课程展示页

<img src="/Users/pc/Desktop/E-learning截图/3.png" alt="3" style="zoom:67%;" />

+ 全部课程页整体由一个`RecycleView`构成。

+ 课程信息栏会展示以下课程信息：

  + 课程视频封面图
  + 课程名称
  + 提供课程的大学
  + 报名人数
  + “国家精品”标签

  为动态加载以上信息，我们在数据库的course表中增加了以下字段：

  + picAddr: 记录课程视频封面地址
  + univ: 记录提供课程的大学
  + sign_num: 记录报名人数
  + isGreat: 记录其是否有“国家精品标签”

+ 点击某一课程栏，可跳转至***课程详情界面***。

### 3.5 课程详情页

<img src="/Users/pc/Desktop/E-learning截图/2.png" alt="2" style="zoom:67%;" />

+ 课程详情页主要由以下信息、功能组成：

  + 课程名称
  + 提供课程的大学
  + 课程参与人数
  + 课程视频
  + 课程开始、结束日期
  + 课程大纲
  + 课程日历
  + 课程注册

  所有信息皆从数据库动态加载。

+ 点击视频中央的三角按钮可以开始播放视频。

+ 查看课程日历：

<img src="/Users/pc/Desktop/E-learning截图/WechatIMG5724.png" alt="WechatIMG5724" style="zoom:67%;" />



### 3.6 个人中心页

<img src="/Users/pc/Desktop/E-learning截图/4.png" alt="4" style="zoom:67%;" />

+ 虽然文档中没有具体要求，但我们觉得登录成功之后确实应该有一个个人中心页面，于是设计了这个界面。
+ 界面可以从user表以下字段中动态加载数据：
  + username: 记录用户姓名
  + user_pic: 记录用户头像
  + phone: 记录用户手机号

### 3.7 资源搜索页

<img src="/Users/pc/Desktop/E-learning截图/7.png" alt="7" style="zoom:67%;" />

+ 在上方搜索栏输入课程编号，点击回车键，即可获取该课程的学习材料。
+ 我们使用API从服务器获取图片、视频、音频、PDF等学习材料，传输到前端展示。
+ 学习材料列表同样使用`RecycleView`展示。

+ 打开视频：

<img src="/Users/pc/Desktop/E-learning截图/8.png" alt="8" style="zoom:67%;" />

+ 打开音频：

<img src="/Users/pc/Desktop/E-learning截图/9.png" alt="9" style="zoom:67%;" />

​	该画面中图片是静态的，只有声音在播放。

+ 打开PDF：

<img src="/Users/pc/Desktop/E-learning截图/10.png" alt="10" style="zoom:67%;" />

+ 在获取图片、视频、音频、PDF等数据时，我们都会使用多线程来提高传输速度，另外，我们会将其存入缓存，确保下次访问时直接从本地获取。

+ 点击右上角的分享按钮，可以分享学习资料。

<img src="/Users/pc/Desktop/E-learning截图/11.png" alt="11" style="zoom:67%;" />



## 四、部分需求实现说明

### 4.1 安卓测试

<img src="/Users/pc/Desktop/E-learning截图/12.png" alt="12" style="zoom: 33%;" />

+ 我们使用junit 4.12单元测试框架，对程序onCreate()方法进行了自动测试。
+ 测试onCreat()方法，实际上对整个程序的构建都进行了测试。
+ 测试结果正常。

### 4.2 保持登录状态

+ 以下是保持登录状态的类，主要使用SharePreferences来实现：

```
public class SpUtil {

    static SharedPreferences prefs;

    public static void init(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * 获取登录状态
     * @param key
     * @return
     */
    public static boolean getBoolean(String key) {
        return prefs.getBoolean(key, false);
    }

    /**
     * 设置登录状态
     * @param key
     * @param data
     */
    public static void setBoolean(String key, boolean data) {
        prefs.edit().putBoolean(key, data).apply();
    }

}
```

+ 通过登录前判断，实现保持登录状态：

```
if ( SpUtil.getBoolean("login")){
    startActivity(Main2Activity.class);
    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    finish();
}
```

### 4.3 多线程下载学习材料

```
public class HttpDownloadManager {

    private static final String TAG = "HttpDownloadManager";
    private String apkUrl, apkName, downloadPath;
    private OnDownloadListener listener;

    public HttpDownloadManager(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public void download(String apkUrl, String apkName, OnDownloadListener listener) {
        this.apkUrl = apkUrl;
        this.apkName = apkName;
        this.listener = listener;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(Constant.THREAD_NAME);
                return thread;
            }
        });
        executor.execute(runnable);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (FileUtil.fileExists(downloadPath, apkName)) {
                FileUtil.delete(downloadPath, apkName);
            }
            fullDownload();
        }
    };
```

```
/**
     * 全部下载
     */
    private void fullDownload() {

        listener.start();
        try {
            URL url = new URL(apkUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setReadTimeout(Constant.HTTP_TIME_OUT);
            con.setConnectTimeout(Constant.HTTP_TIME_OUT);
            con.setRequestProperty("Accept-Encoding", "identity");
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = con.getInputStream();
                int length = con.getContentLength();
                int len;
                //当前已下载完成的进度
                int progress = 0;
                byte[] buffer = new byte[1024 * 2];
                File file = FileUtil.createFile(downloadPath, apkName);
                FileOutputStream stream = new FileOutputStream(file);
                while ((len = is.read(buffer)) != -1) {
                    //将获取到的流写入文件中
                    stream.write(buffer, 0, len);
                    progress += len;
                    listener.downloading(length, progress);
                }
                listener.done(file);
                //完成io操作,释放资源
                stream.flush();
                stream.close();
                is.close();
                //重定向
            } else if (con.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM ||
                    con.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                apkUrl = con.getHeaderField("Location");
                con.disconnect();
                Log.e(TAG, "fullDownload: 当前地址是重定向Url，定向后的地址：" + apkUrl);
                fullDownload();
            } else {
                listener.error(new SocketTimeoutException("连接超时！"));
            }
            con.disconnect();
        } catch (Exception e) {
            listener.error(e);
            e.printStackTrace();
        }
    }
}
```

### 4.4 文件缓存至本地

+ 打开文件前判断文件是否缓存至本地，如已缓存，直接加载；如未缓存，开始下载。

```
coursevideo = (Coursevideo) getIntent().getSerializableExtra("list");

findViewById(R.id.share).setOnClickListener(view -> {
    if (coursevideo != null && coursevideo.getMediatype().equals("image")) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(localPath);
        shareMoreImages(strings);
    }
});

if (coursevideo != null) {
    
    FileBean fileBean = DaoHelper.getInstance(this).queryFileIsExist(coursevideo.getMaterialUrl());
    
    if (fileBean == null) {
        //文件无缓存 开始下载
        downLoadFile(coursevideo);
        return;
    }
    
    //文件已缓存 直接加载
    localPath = fileBean.getLocalPath();
    File file = FileUtil.fileExists(localPath);

    if (coursevideo.getMediatype().equals("image")) {
        pdfView.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);
        if (file.exists()) {
            Glide.with(this).load(file).into(imageView);
        } else {
            downLoadFile(coursevideo);
        }
    } else if (coursevideo.getMediatype().equals("pdf")) {
        pdfView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);
        if (file.exists()) {
            initPDf(file);
        } else {
            downLoadFile(coursevideo);
        }
    }
} else {
    finish();
}
```

### 4.5 MVVM及Kotlin的应用

+ 我们使用mvvm框架及Kotlin重写了教师信息详情页面。代码如下：

  MVVMKotlinTeacherDetailActivity:

```
class MVVMKotlinTeachDetailActivity : AppCompatActivity() {

    val viewModel by lazy { ViewModelProviders.of(this).get(TeacherViewModel::class.java) }

    private val binding by lazy { DataBindingUtil.setContentView<ActivityMvvmKotlinTeacherBinding>(this, R.layout.activity_mvvm_kotlin_teacher) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("teacherId")

        viewModel.mutableLiveData.observe(this, Observer {
            if (it != null) {
                binding.teacher = it;
            }
        })
        viewModel.getDatas(id);
    }

}
```

​	   TeacherViewModel:

```
class TeacherViewModel : ViewModel() {

    internal var mutableLiveData = MutableLiveData<TeacherBean>()


    fun getDatas(teacherId:String) {

        OkGo.get<String>(BaseUrl.baseUrl + "teacher/" + teacherId)
                .execute(object : StringCallback() {
                    override fun onSuccess(response: Response<String>) {
                        val gson = Gson()
                        val teacherBean = gson.fromJson<TeacherBean>(response.body(), object : TypeToken<TeacherBean>() {
                        }.type)
                        mutableLiveData.postValue(teacherBean)
                    }
                })
    }

}
```



​	







