public function post_confirm(){
	
	$arrayError2=array('error'=>'2')
	$arrayError1=array('error'=>'1')
	$arrayError3=array('error'=>'3')

	$id=Input::get('service_id');
	$driverId=Input::get('driver_id')

	$servicio=Service::find($id)

	if($servicio!=null){
		
	
		if($servicio->status_id=='6'){
			return $arrayError2 
		}

		if($servicio->driver_id==NULL && $servicio->status-Id=='1'){

			$service=updateService($id,array('driver_id'=>$driver_id,'status_id'=>'2'));

		
			updateDriver($driver_id,array("available"=>'0'));
			$driverTemp=findDriver($driver_id);
			updateService($id,array('car_id'=>$driverTemp->car_id,'status_id'=>'2'));

			$result=pushmensaje($id,'tu servicio ha sido confirmado');

		}else{
			return $arrayError1;
		}
	}else{
		return $arrayError3;
	}
}
/**

Funcion para actualizar un servicio.
**/
public function updateService(id,params){
	return Service::update($id,$params);
}

/**

Funcion para actualizar un conductor.
**/
public function updateDriver(id,params){
	return Driver::update($id,$params);
}


/**

Funcion para buscar un conductor.
**/
public function findDriver(id){
	return Driver::find($id)
}


/**
	Funcion para enviar un mensaje de notificacion
**/
public function pushMessage(id,msj){
	
	$servicio=Service::find($id);
	$push=Push::make();

	$arrayError=array('error'=>'0')
	$arrayserviceId=array('serviceId'=>$servicio->id)
	$uuid=$servicio->user->uuid

	if($uuid==''){

		return Response::json($arrayError);
	}

	if($servicio->user->type=='1'){

		$result=push->ios($uuid,$msj,'honk.wav','Open',$arrayserviceId);

	}else{
		$result=push->android2($uuid,$msj,'default.wav','Open',$arrayserviceId);
	}
	return $arrayError;


}