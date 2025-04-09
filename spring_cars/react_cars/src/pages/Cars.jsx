import { useContext, useEffect, useState } from "react";
import GlobalContext from "../contexts/GlobalContext";
import Modal from "../components/Modal";
import CarCard from "../components/CarCard";

export default function Cars() {

    //costante per i dati delle car
    const [cars, setCars] = useState([]);

    //richiamo l'url 
    const { apiUrl } = useContext(GlobalContext);

    //fetch dei dati
    function fetchData(url = apiUrl) {
        fetch(url)
            .then(res => res.json())
            .then(res => {
                console.log(res);
                const carsData = res.data;
                setCars(carsData);
            })
    }

    //faccio la chiamata solo al caricamento del componente
    useEffect(fetchData, []);

    return (
        <>

            <div className="container text-center mt-3 p-3">
                <h1>Our Cars</h1>
            </div>

            <div className="container mt-4">
                <div className="row g-4 d-flex justify-content-between">
                    <div className="col-sm-6 col-md-4">
                        {cars.map(car => <CarCard key={car.id} car={car} />)}
                    </div>

                    <div className="btn-modals">

                        {/*Modale*/}
                        <Modal url={apiUrl} />
                    </div>
                </div>
            </div>

        </>
    )
}