//读文件
public String readSDFile(String fileName) throws IOException
{
File file=new File(fileName);
FileInputStream stream =new FileInputStream(file);
int length=stream.available();
byte data[]=new byte[length];
stream.read(data);
stream.close();
return res;
}
//写文件
public void writeSDFile(String fileName,String writestr) throws IOException
{
File file=new File(fileName);
FileOutputStream stream=new FileOutputStream(file);
byte data[]=writestr.getBytes();
stream.write(data);
stream.close();
}