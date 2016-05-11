ScaledView : UserView{

	var <>roundationF;
	var <>defSize, <>spec;
	
	*new{ arg p, b, defSize=20@20;
		^super.new(p, b).defSize_(defSize)
	}
	roundation{ arg x, y;
		^if(roundationF.notNil)
		{roundationF.value(x, y, this.bounds.width, this.bounds.height)}
		{this.defRoundation(x, y)}
	}
	defRoundation{ 
		arg x, y;
		^[
			x.div(defSize.x)*defSize.x,
			y.div(defSize.y)*defSize.y,
		]
	}
	mouseMove{ arg x, y, mod;
		^mouseMoveAction
		.value(*([this]++this.roundation(x, y)++mod++[x, y]))
	}
	mouseDown{ arg x, y, mod, but, nbCl;
		^mouseDownAction
		.value(*([this]++this.roundation(x, y)++[mod, but, nbCl]++[x, y]))
	}
	canReceiveDrag { arg x, y;
		if( canReceiveDragHandler.notNil )
		{
			^this.canReceiveDragHandler.value
			( *[this]++this.roundation(x, y) )
		}
		{ ^(
			this.tryPerform(
				*\defaultCanReceiveDrag.asArray++ this.roundation(x, y))
			? false ) };
	}
	receiveDrag { arg x, y;
		if( receiveDragHandler.notNil )
		{ this.receiveDragHandler.value( *[this]++ this.roundation(x, y) ) }
		{ this.tryPerform( \defaultReceiveDrag, x, y ) }; //grosse flemme
	}
	
}

