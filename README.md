# RxBusLib
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.raoqingmou:RxBusLib:1.0.1'
	}

Step 3. 举个栗子

	/**
	 * 发送的方法，发送的code和数据，会有双重验证
	 */
	RxBus.getInstance().post(101,TAG);

	/**
	 * 接收的方法，验证发送的code和发送的数据类型同时通过才会触发
	 */
        RxBus.getInstance().tObservable(this, 101, String.class, new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });
	
	/**
	 * 注销方法
	 * 一般在你的BaseActivity中的onDestroy加上这个方法就行，其他地方无需做处理
	 * 有生命周期的base类（广播接收者，服务等）里面的onDestroy加上这个，你有用到此RxBus的话。
	 */
        RxBus.getInstance().unRegister(this);
	
	
	
	
