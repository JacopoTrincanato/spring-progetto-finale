import { useContext, useEffect, useState } from "react";
import GlobalContext from "../contexts/GlobalContext";
import CarCard from "../components/CarCard";
import axios from "axios";

export default function Cars() {

    //costante per i dati delle car
    const [cars, setCars] = useState([]);

    //richiamo l'url 
    const { apiUrl } = useContext(GlobalContext);

    //fetch dei dati
    function fetchData(url = apiUrl) {
        axios.get(url)
            .then(res => {
                console.log(res.data);
                const carsData = res.data;
                setCars(carsData);
            })
    }

    //faccio la chiamata solo al caricamento del componente
    useEffect(fetchData, []);

    console.log(cars);

    return (
        <>

            <div className="container text-center mt-3 p-3">
                <h1>Our Cars</h1>
            </div>

            <div className="container mt-4">
                <div className="row g-4 d-flex justify-content-between">
                    <div className="row g-4 d-flex justify-content-between">
                        {cars && cars.map(car => (
                            <div className="col-sm-6 col-md-4" key={car.id}>
                                <CarCard car={car} />
                            </div>
                        ))}
                    </div>
                </div>
            </div>

        </>
    )
}