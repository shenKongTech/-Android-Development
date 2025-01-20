InputStream stream=getResources().openRawResource(R.raw.test);
			try
			{
			int length=stream.available();
			byte data[]=new byte[length];
			stream.read(data);
			stream.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}