public void writeFile(String fileName,String writeStr) throws IOException
{
try
{
FileOutputStream stream=openFileOutout(fileName,MODE_PRIVATE);
byte data[]=writeStr.getBytes();
stream.write(data);
stream.close();
catch(IOException e)
{
e.printStackTrace();
}

}




}