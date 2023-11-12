import {useEffect, useState} from "react";
export default function SetState_01(){
    let [object, setObject] = useState( {
        a: 1,
        b: 2,
        c: 3,
        d: 4,
        e: 5,
        f: {
            g: 6,
            h: 7,
            i: 8
        }
    })

    console.log(object)
    useEffect(() => {
        object.a = 'a'
        setObject(object);
        //setObject( {...object, a: 'a'} )

    }, []);
    console.log(object)
    return(<>
    </>)
}