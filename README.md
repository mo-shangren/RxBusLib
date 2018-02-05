# RxBusLib

改动: 添加对Lifecycle组件的支持(对实现了Lifecycle的订阅者自动绑定生命周期,无需再手动调用unRegister(), 未实现Lifecycle的订阅者依旧需手动,调用方式不变)
已通过内存溢出测试

---

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
