Button btn1=findViewById(R.id.btn1);
		class Myclick implements View.OnClickListener
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(MainActivity.this,"你单击了此按钮",Toast.LENGTH_SHORT).show();
			}
		}
		btn1.setOnClickListener(new Myclick());