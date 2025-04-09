export default function Modal({ car, apiUrl, setCars }) {

    //creo una funzione per cancellare la car
    function handleDeleteClick(e) {

        //prevengo il comportamento di default
        e.preventDefault()

        fetch(`${apiUrl}/` + car.id, {
            method: 'DELETE',
            headers: { "Content-type": "Application/json" }

        })
            .then(res => res.json())
            .then(res => {
                console.log(res)
                setCars(res.data)
            })
    }

    return (
        <>
            <div className="modal fade" id={`modal-${car.id}`} data-bs-backdrop="static" data-bs-keyboard="false"
                tabIndex="-1" aria-labelledby={`modalLabel-${car.id}`} aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h1 className="modal-title fs-5" id={`modalLabel-${car.id}`}>
                                Delete car {car.model}
                            </h1>
                            <button type="button" className="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            Are you sure you want to delete the car: {car.model}
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary"
                                data-bs-dismiss="modal">Close</button>
                            <form onSubmit={handleDeleteClick}>
                                <button type="submit" className="btn btn-danger">Delete</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}