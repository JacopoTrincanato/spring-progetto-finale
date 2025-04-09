import { useContext, useEffect, useState } from "react";
import { data, Link } from "react-router-dom";
import GlobalContext from "../contexts/GlobalContext";
import Modal from "../components/Modal";

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
                        <div className="car-card">
                            {/*<img src={urlImage} className="card-img-top" />*/}
                            <div className="card-body p-3">
                                <h5 className="card-title">b</h5>
                                <p className="card-text">bb</p>
                                <Link className="btn btn-car">Details</Link>
                                {/*to={`/${id}`}</div>*/}
                            </div>
                            <button type="button" className="btn delete-btn" data-bs-toggle="modal"
                                data-bs-target={`#modal-{}`}>
                                &#10005;
                            </button>
                        </div>
                    </div>

                    <div className="btn-modals">

                        {/*Modale*/}
                        <Modal />
                    </div>
                </div>
            </div>

        </>
    )
}