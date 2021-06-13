package team.sdguys.util;

import com.oreilly.servlet.multipart.FileRenamePolicy;

import java.io.File;
import java.util.UUID;

/**
 * 自定义上传文件的命名策略：针对一次上传一个文件
 */
public class CustomFileRenamePolicy implements FileRenamePolicy {

    //实现FileRenamePolicy接口，可以创建一个文件重命名策略类，来指定上传的文件如何重命名
    //需要实现rename()来指定如何重命名上传的文件
    //可通过传入的File对象来获取上传的文件的信息
    @Override
    public File rename(File file) {
        //获取上传的文件的原名称，例如Tulips.jpg
        String fileName = file.getName();
        //获取上传的文件的扩展名
        String extensionName = fileName.substring(fileName.lastIndexOf("."));
        //产生一个新名字，这里利用UUID类的randomUUID()方法产生一个随机的32位字符串
        String newName = UUID.randomUUID().toString().replace("-", "") + extensionName;
        //重命名文件
        File newFile = new File(file.getParent(), newName);
        return newFile;
    }
}
