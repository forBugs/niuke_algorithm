package p02;

import java.io.File;
import java.util.UUID;

public class Demo {
    public static  int m = 200;
    public static void main(String[] args) throws  Exception{

        String dirPath = "C:\\Users\\fb\\Desktop\\批量生成";
        File dir = new File(dirPath);
        renameFile(dir);

    }
     static void renameFile(File dir) throws Exception {
        File[] fs = dir.listFiles();
        for (int i = 0; i < fs.length; i++) {
            //打印全路径名称
            System.out.println(fs[i].getAbsolutePath());

            //判断文件是否存在
            if(!fs[i].exists())
            {
                fs[i].createNewFile();
            }
            System.out.println("修改前文件名称是："+fs[i].getName());
            String rootPath = fs[i].getParent();
            System.out.println("根路径是："+rootPath);
            File newFile = new File(rootPath + File.separator + UUID.randomUUID().toString()+ ".exe");
            System.out.println("修改后文件名称是："+newFile.getName());
            if (fs[i].renameTo(newFile))
            {
                System.out.println("修改成功!");
            }
            else
            {
                System.out.println("修改失败");
            }

        }


    }


}
