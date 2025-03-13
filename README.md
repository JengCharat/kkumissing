<<<<<<< HEAD

# kkuของหาย เว็บไซต์ที่ช่วยหาของที่หายหรือส่งคืนของที่หายภายในมหาวิทยาลัยขอนแก่น

ผู้จัดทำ

นายแก้วเพ็ชรัตน์ สีสันต์[**JengCharat**](https://github.com/JengCharat)

นายณัฐธเนศ กำเนิดกาลึม([**natthaneto**](https://github.com/natthaneto))

นางสาวณิชกานต์ จูประพัทธศรี([**Nichagan-J**](https://github.com/Nichagan-J))

เทคโนโลยีที่ใช้
Android studio (ladybug)
Xampp
ดึงข้อมูลจาก gps (https://developer.android.com/develop/sensors-and-location/location/retrieve-current?hl=th)

## ขั้นตอนในการติดตั้ง

```bash
git clone https://github.com/JengCharat/kkumissing.git
```

# วิธีการใช้งาน

1.ถ้าหลังจากที่โหลดมาแล้วไม่มี device ให้ select
ไปที่ file->project structure->Modeuls->propoties->เลือก api35

2.ถ้า ใช้ window ไปที่ gradle propoties แล้วเปลี่ยน จาก
org.gradle.jvmargs=-Xmx1536m -Duser.country=US -Duser.language=en
เป็นorg.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8

3.ถ้า sdk ไม่ตรงให้ไปที่ local.properties แล้วเปลี่ยนให้ตรง

4.ไปที่com/example/mobileproject/ui/home/HomeFragment.kt แล้ว แก้ไข ip เป็น server ของคุณ

5.สร้าง table ใน mysql
ตัวอย่างข้อมูล อยู่ที่ java/com/example/mobileproject/web-app-test.sql
ถ้าต้องการแค่ table อยู่ที่ java/com/example/mobileproject/web-app-test-2.sql

6.นำ api ไปวางที่ xampp ที่ folder htdocs/myapi/
ถ้าไม่มี folder myapi ให้สร้าง folder
ไฟล์ api อยู่ที่ com/example/mobileproject/test5.txt
com/example/mobileproject/test6.txt
ให้แก้เป็น .php ด้วย

## ตัวอย่างรูปภาพที่ใช้ upload

https://tinypng.com/images/social/website.jpg

https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgolBdeaXdt7hZ4G28YiA8shOCg4jkBg08uA&s
